import java.util.HashMap;

public class CustomerStorage
{
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data)
    {
        try {
        String[] components = data.split("\\s+");
        if (components.length < 4){
            throw new ArrayIndexOutOfBoundsException("Wrong format" + "Correct form: add Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        String name = components[0] + " " + components[1];
            if (components[2].matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$") && (components[3].matches("\\+[0-9]+") && components[3].length() == 12)) {
        storage.put(name, new Customer(name, components[3], components[2]));
            }else if (!components[2].matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
                throw new IllegalArgumentException("Wrong email format");
            }else if (!(components[3].matches("\\+[0-9]+") && components[3].length() == 12)){
                throw new IllegalArgumentException("Wrong mobile format");
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name)
    {
        storage.remove(name);
    }

    public int getCount()
    {
        return storage.size();
    }
}