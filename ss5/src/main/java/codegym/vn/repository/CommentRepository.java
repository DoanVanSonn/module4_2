package codegym.vn.repository;

import codegym.vn.bean.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class CommentRepository implements ICommentRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Comment> findAll() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        String todayStr = dateFormat.format(new Date());
        Date today = null;
        try {
            today = dateFormat.parse(todayStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return entityManager.createQuery("select c from Comment as c where c.date = :today")
                .setParameter("today", today).getResultList();
    }

    @Override
    public void comment(Comment comment) {
        entityManager.persist(comment);
    }

    @Override
    public void like(int id) {
        entityManager.createQuery("update Comment c set c.like = c.like + 1 where c.id = :id")
                .setParameter("id", id).executeUpdate();
    }
}
