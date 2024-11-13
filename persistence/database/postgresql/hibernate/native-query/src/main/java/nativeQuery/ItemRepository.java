package nativeQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemRepository {

    @Autowired
    private EntityManager entityManager;

    public List<Object[]> getAll(){
        String query = "SELECT id, content FROM item";
        Query nativeQuery = entityManager.createNativeQuery(query);
        return nativeQuery.getResultList();
    }

}
