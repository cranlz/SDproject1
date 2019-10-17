import javax.swing.*;

public class StoreManager {
    public static final String DBMS_SQ_LITE = "SQLite";
    public static final String DB_FILE = "C:/Users/cnnrl/Documents/Classwork/store.db";

    IDataAdapter adapter = null;
    private static StoreManager instance = null;

    public static StoreManager getInstance() {
        if (instance == null) {
            String dbfile = DB_FILE;
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
                dbfile = fc.getSelectedFile().getAbsolutePath();
            instance = new StoreManager(DBMS_SQ_LITE, dbfile);
        }
        return instance;
    }

    private StoreManager(String dbms, String dbfile) {
        if (dbms.equals("Oracle"))
            adapter = new OracleDataAdapter();
        else if (dbms.equals("SQLite"))
            adapter = new SQLiteDataAdapter();
        adapter.connect(dbfile);
    }

    public IDataAdapter getDataAdapter() {
        return adapter;
    }

    public void setDataAdapter(IDataAdapter a) {
        adapter = a;
    }

    public void run() {
        MainView ui = new MainView();
        ui.view.setVisible(true);
    }

    public static void main(String[] args) {
/*        SQLiteDataAdapter adapter = new SQLiteDataAdapter();
        adapter.connect();
        ProductModel product = adapter.loadProduct(3);

        System.out.println("Loaded product: " + product);

        AddProductView apView = new AddProductView();
        AddProductController apCtr = new AddProductController(apView, adapter);

        apView.setVisible(true);

        AddCustomerView cView = new AddCustomerView();
        AddCustomerController cCtr = new AddCustomerController(cView, adapter);
        cView.setVisible(true);*/

        StoreManager.getInstance().run();
    }
}
