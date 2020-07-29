import Debug.Trace
import Data.List

main = do
    let a = Concept "A"
        b = Concept "B"
        c = Concept "C"
        d = Concept "D"
        e = Concept "E"
        r = Role "R"
        s = Role "S"

    putStrLn (show (run [a`Implies`b/\r!.c,
        c `Implies`s!.d,
        r!.s!.Top/\b`Implies`d] a d))
    getChar

    

type Name = String
data Role = Role Name              -- $N_R$
    deriving (Show, Eq)


data Concept = Concept Name        -- $N_C$
             | Top
             | Conj Concept Concept
             | Some Role Concept
    deriving (Show, Eq)

infixl 4 `Implies`
infixl 4 `Equiv`
data Axiom = Concept `Implies` Concept
            |Concept `Equiv` Concept
            deriving (Show, Eq)
type TBox = [Axiom]

infixl 6 /\
infixr 7 !.
(/\) = Conj
(!.) = Some

data Super = Super { self :: Concept,
                         sup :: [Concept]
                       } deriving (Eq, Show)


norm _ []=[]
norm i (t:ts)=if (head ret)==t then (head ret): norm (i+1) (tail ret ++ts)
                             else norm (i+1) (ret ++ ts)
    where ret=norm' i t

norm'::Int->Axiom->TBox
norm' i t=case t of
    a `Equiv` b ->[a`Implies`b , b`Implies`a]--NF1
    a `Implies` Conj c d ->[a `Implies` c, a `Implies` d]--NF6
    a `Implies` b->if complex a && complex b then[a `Implies` Concept ("new"++show i),Concept ("new"++show i) `Implies` b]--NF2
                   else if complex a then [fst(split a)`Implies`Concept ("new"++show i),snd(split a)`Implies`b]--NF3,4
                   else if complex b then [a `Implies`snd(split b),Concept ("new"++show i)`Implies`fst(split b)]--NF5
                   else [t]
    where
        complex a=case a of
            Conj a b->complex' a || complex' b
            Some _ a->complex' a
            _->False
        complex' a=case a of
            Conj _ _->True
            Some _ _->True
            _->False

        split a=case a of
            Some a b->(b,Some a (Concept ("new"++show i)))
            Conj a b->if complex' a then (a,Conj (Concept ("new"++show i)) b)
                      else (b,Conj (Concept ("new"++show i)) a)


cons ::TBox->[Super]
cons ts=init(unique(extract ts))
  where init []=[]
        init (c:cs)=(Super c [c,Top]):init cs

extract::TBox->[Concept]
extract []=[]
extract (t:ts)=extract' t ++ extract ts

extract'::Axiom->[Concept]
extract' (a `Implies` b)=extr a ++ extr b
  where
    extr c=case c of
      Conj e f ->extr e ++ extr f
      Some _ d ->extr d
      Top->[]
      _ -> [c]


unique :: Eq a => [a] -> [a]
unique (x : y : lst) = if x `elem` y:lst then unique (y : lst)
                   else x:unique (y : lst)
unique lst = lst


run::TBox->Concept->Concept->Bool
run ts a b=check norms norms supers a b
  where
    norms=norm 1 ts
    supers=cons norms


check::TBox->TBox->[Super]->Concept->Concept->Bool
check _ [] ssc a b=if suc a b ssc then True
                  else False
check tsc (t:ts) ssc a b=case t of
  Conj a1 a2 `Implies` a3->if suc a b ssc then True--R1
                           else if  r1/=ssc then trace("rule1 applyed success: "++show t++"\n---\n|||\n"++show r1++"\n|||\n---")check tsc tsc r1 a b
                           else check tsc ts ssc a b
    where
      r1=rule1 a1 a2 a3 ssc
      rule1 _ _ _ []=[]
      rule1 a1 a2 a3 (s:ss)=if(a1`elem`(sup s)&&a2`elem`(sup s)) then s{sup=unique(a3:(sup s))}:(rule1 a1 a2 a3 ss)
                          else s:(rule1 a1 a2 a3 ss)
-----------------------------------------------------------------------------------------                          
  b1 `Implies` Some b2 b3->if suc a b ssc then True--R2
                           else if r2/=tsc then trace("rule2 applyed success: "++show t++"\n---\n|||\n"++show r2++"\n|||\n---")check r2 r2 ssc a b
                           else check tsc ts ssc a b
    where  
      r2=unique(rule2 b1 b2 b3 tsc ssc)
      rule2 _ _ _ tt []=tt
      rule2 b1 b2 b3 tt (s:ss)=if(b1`elem`(sup s)) then (rule2 b1 b2 b3 (unique(newt:tt)) ss)
                                else rule2 b1 b2 b3 tt ss
        where
          newt=self s`Implies`Some b2 b3
-----------------------------------------------------------------------------------------
  Some c1 c2 `Implies`c3->if suc a b ssc then True--R3
                          else if r3/=ssc then trace("rule3 applyed success: "++show t++"\n---\n|||\n"++show ssc++"\n"++show r3++"\n|||\n---")check tsc tsc r3 a b
                          else check tsc ts ssc a b
    where
      r3=rule3 c1 c2 c3 test ssc
      test=ex tsc
      ex []=[]
      ex (t:tt)=case t of
        x `Implies`Some c1 y->(x,y):(ex tt)
        _->ex tt
      rule3 _ _ _ [] ss=ss
      rule3 c1 c2 c3 (t:tt) ss=if added/=ss then rule3 c1 c2 c3 tt added
                             else rule3 c1 c2 c3 tt ss
        where
          added=if ok c2 (snd(t)) ss then add c3 (fst(t)) ss
                else ss
          ok _ _ []=False
          ok c2 y (s:ss)= y==(self s)&&c2`elem`(sup s)||ok c2 y ss
          add _ _ []=[]
          add c3 x (s:ss)= if(x==(self s))then s{sup=unique(c3:(sup s))}:add c3 x ss
                           else s:add c3 x ss
  d1 `Implies` d2->if added/=ssc then check tsc tsc added a b
                                   else check tsc ts ssc a b
    where
      added=add d1 d2 ssc
      add _ _ []=[]
      add d1 d2 (s:ss)=if d1==self s then s{sup=unique(d2:sup s)}:add d1 d2 ss
                       else s:add d1 d2 ss

suc::Concept->Concept->[Super]->Bool
suc a b []=False
suc a b (s:ss)=((self s)==a && b`elem`(sup s))||suc a b ss