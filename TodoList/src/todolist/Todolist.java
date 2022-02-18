package todolist;

public class Todolist {
    public static String[] model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    
    public static void main(String[] args) {
        viewShowTodoList();
    }
    
    /**
     * Menampilkan Todo List
     */
    public static void showTodoList() {        
        for (var i = 0; i < model.length; i++) {
            var nomor = i + 1;
            var task = model[i];
            
            if (task != null) {
                System.out.println(nomor + ". " + task);
            }
        }
    }
    
    public static void testShowTodoList() {
        model[0] = "Belajar Java";
        model[1] = "Belajar PHP";
        model[2] = "Belajar Laravel";
        showTodoList();
    }
    
    /**
     * Menambahkan Task ke List
     * @param task Nama task
     */
    public static void addTodoList(String task) {
        // Cek model penuh atau tidak.
        var isFull = true;
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }
        
        // Resize ukuran array 2x lipat jika model penuh.
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];
            
            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }
        
        // Tambahkan task ke posisi ke data array yang bernilai null.
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = task;
                break;
            }
        }
    }
    
    public static void testAddTodoList() {
        for (var i = 1; i <= 25; i++) {
            addTodoList("Task ke-" + i);
        }
        
        showTodoList();
    }
        
    /**
     * Menghapus Task dari List
     * @param number Nomor Task yang ingin Dihapus
     * @return Status dari Task yang berhasil dihapus atau tidak
     */
    public static boolean removeTodoList(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (var i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
       }
    }
    
    public static void testRemoveTodoList() {
        for (var i = 1; i <= 5; i++) {
            addTodoList("Task ke-" + i);
        }
        
        var result = removeTodoList(20);
        System.out.println(result);
        
        result = removeTodoList(8);
        System.out.println(result);
        
        result = removeTodoList(2);
        System.out.println(result);
        
        showTodoList();
    }
    
    /**
     * Menerima Input
     * @param info Info data yang akan diminta
     * @return Data yang telah diinput
     */
    public static String input(String info) {
        System.out.print(info + ": ");
        String data = scanner.nextLine();
        return data;
    }
    
    public static void testInput() {
        var name = input("Nama");
        System.out.println("Hai " + name);
        
        var major = input("Program Studi");
        System.out.println(major);
    }
    
    /**
     * Menampilkan View Todo List
     */
    public static void viewShowTodoList() {
        while (true) {
            System.out.println("Aplikasi Todo List");
            showTodoList();
        
            System.out.println("Menu:");
            System.out.println("1. Tambah Task");
            System.out.println("2. Hapus Task");
            System.out.println("x. Keluar");

            var input = input("Pilihan");
            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("\nPilihan Anda tidak valid!");
            }
        }
    }
    
    public static void testViewShowTodoList() {
        for (var i = 1; i <= 5; i++) {
            addTodoList("Task ke-" + i);
        }
        
        viewShowTodoList();
    }
    
    /**
     * Menampilkan View Menambahkan Todo List
     */
    public static void viewAddTodoList() {
        System.out.println("\nMenambah Task");
        
        var task = input("Task (x jika batal)");
        if (task.equals("x")) {
            System.out.print("\n");
        } else {
            addTodoList(task);
            System.out.println("\nTask telah berhasil ditambahkan!");
        }
    }
    
    public static void testViewAddTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        viewAddTodoList();
        showTodoList();
    }
    
    /**
     * Menampilkan View Menghapus Todo List
     */
    public static void viewRemoveTodoList() {
        System.out.println("\nMenghapus Task");
        showTodoList();
        
        var task = input("Nomor task yang dihapus (x jika batal)");
        if (task.equals("x")) {
            System.out.print("\n");
        } else {
            boolean success = removeTodoList(Integer.valueOf(task));
            if (!success) {
                System.out.println("\nGagal menghapus task: " + task);
            } else {
                System.out.println("\nTask telah berhasil dihapus!");
            }
        }
    }
    
    public static void testViewRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        
        showTodoList();
        viewRemoveTodoList();
        showTodoList();
    }
}
