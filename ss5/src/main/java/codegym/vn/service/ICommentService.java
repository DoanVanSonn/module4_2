package codegym.vn.service;

import codegym.vn.bean.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAll();

    void comment(Comment comment);

    void like(int id);
}
