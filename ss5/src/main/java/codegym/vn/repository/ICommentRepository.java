package codegym.vn.repository;

import codegym.vn.bean.Comment;

import java.util.List;

public interface ICommentRepository {
    List<Comment> findAll();

    void comment(Comment comment);

    void like(int id);
}
