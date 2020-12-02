package com.zsy.blog.entity.article.dto;

import com.zsy.blog.entity.article.Article;
import com.zsy.blog.entity.operation.Tag;
import lombok.Data;

import java.util.List;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2020-12-02 15:31
 */
@Data
public class ArticleDTO extends Article {


    private static final long serialVersionUID = -6240833759412988706L;


    private List<Tag> tagList;

}
