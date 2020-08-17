package com.zz.dao;

import com.zz.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    int addBlog(Blog blog);

    //查询博客
    List<Blog> queryBlogIf(Map map);
}
