package com.zsy.blog.entity.article.vo;

import com.zsy.blog.entity.article.Article;
import com.zsy.blog.entity.operation.Tag;
import lombok.Data;

import java.util.List;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2020-12-02 15:30
 */
@Data
public class ArticleVo extends Article {

    private static final long serialVersionUID = 616170231789199615L;
    /**
     * 所属分类，以逗号分隔
     */
    private String categoryListStr;

    /**
     * 所属标签
     */
    private List<Tag> tagList;

}
