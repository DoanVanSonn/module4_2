package codegym.vn.service;

import codegym.vn.bean.Comment;
import codegym.vn.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService {
    @Autowired
    private ICommentRepository repository;

    @Override
    public List<Comment> findAll() {
        return repository.findAll();
    }

    @Override
    public void comment(Comment comment) {
        repository.comment(comment);
    }

    @Override
    public void like(int id) {
        repository.like(id);
    }
}
