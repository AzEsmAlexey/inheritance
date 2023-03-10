import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    Product item1 = new Product(001, "Как повелевать гусями", 666);
    Book item2 = new Book(020, "Как повелевать гусями 2. Апофеоз.", 777, "Сетраков");
    Smartphone item3 = new Smartphone(300, "Я телефон", 888, "CyberCat");

    @Test

    public void testSearchBySeveralResponses() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);

        Product[] actual = manager.searchBy("Как");
        Product[] expected = {item1, item2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void testSearchByOneResponse() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);

        Product[] actual = manager.searchBy("Я телефон");
        Product[] expected = {item3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void testSearchByErroneousRequest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        manager.add(item1);
        manager.add(item2);
        manager.add(item3);

        Product[] actual = manager.searchBy("я тилефон");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }


}
