import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.NotFoundException;
import ru.netology.repository.ProductRepository;

public class ProductRepositoryTest {

    Product item1 = new Product(001, "Как повелевать гусями", 666);
    Book item2 = new Book(020, "Собаке собачья собака", 777, "Павлов");
    Smartphone item3 = new Smartphone(300, "Я телефон", 888, "CyberCat");
    @Test
    public void testSaveMethod() {
        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);

        Product[] expected = {item1, item2, item3};
        Product[] actual = repo.getAllItems();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSaveMethodEmpty() {
        ProductRepository repo = new ProductRepository();

        Product[] expected = {};
        Product[] actual = repo.getAllItems();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testRemoveByIdMethod() {
        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.removeById(item3.getId());

        Product[] expected = {item1, item2};
        Product[] actual = repo.getAllItems();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testRemoveByIdMethodEmpty() {
        ProductRepository repo = new ProductRepository();
        repo.save(item1);
        repo.removeById(item1.getId());

        Product[] expected = {};
        Product[] actual = repo.getAllItems();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testRemoveByIdNotExist() {
        ProductRepository repo = new ProductRepository();
        repo.save(item1);


        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(666);
        });
    }
}
