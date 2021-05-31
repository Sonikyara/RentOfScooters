package eu.senla.statkevich.scooters.dao;

import eu.senla.statkevich.scooters.dao.IDao.ITypeProducerDao;
import eu.senla.statkevich.scooters.entity.entities.TypesProducers;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(classes = {JPAConfig.class}, loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TypeProducerDAOTest extends TestCase {

    @Autowired
    private ITypeProducerDao typeProducerDao;

    @Test
    public void testRead() {
        TypesProducers resultTypesProducers=typeProducerDao.read(1L);

        assertNotNull(resultTypesProducers);
    }
}