import java.util.*;

interface check {
    public void searching(ArrayList<Item> item_arr,Company comp);
    public void show_reward();
    public void show_details();
}

class Company{

    private Account company_account;
    private boolean exit_application=false;
    private String company_name;
    private ArrayList<Merchant> merchant_arr;
    private ArrayList<Customer> customer_arr;
    public ArrayList<Item> item_arr;
    private double company_contribution;
    Scanner scan = new Scanner(System.in);
    private boolean merchant_menu_flag=true;
    Merchant abc = new Merchant("","");
    int temp_int;
    Customer def = new Customer("","");
    private boolean customer_menu_flag=true;

    Company(String company_name){
        this.company_account= new Account();
        this.company_contribution=0;
        this.company_name=company_name;
        this.merchant_arr=new ArrayList<Merchant>();
        this.customer_arr=new ArrayList<Customer>();
        this.item_arr = new ArrayList<Item>();
    }
    public double get_company_contribution(){
        return this.company_contribution;
    }
    public void add_company_contribution(int f){
        double x = (double)f;
        x=x/100;
        // System.out.println("contri "+x);
        this.company_contribution+=x;
        // System.out.println("current contri : "+this.company_contribution);
    }
    public double get_company_balance(){
        // return this.company_account.get_balance();
        return this.company_contribution;
    }
    public String get_company_name(){
        return this.company_name;
    }
    public void display_welcome(){
        System.out.println("Welcome to "+this.company_name);
    }
    public void start_application(){
        Merchant abc = new Merchant("Jack","Unknown"); 
        merchant_arr.add(abc);
        abc = new Merchant("John","Unknown"); 
        merchant_arr.add(abc);
        abc = new Merchant("James","Unknown"); 
        merchant_arr.add(abc);
        abc = new Merchant("Jeff","Unknown"); 
        merchant_arr.add(abc);
        abc = new Merchant("Joseph","Unknown"); 
        merchant_arr.add(abc);
        Customer sdf = new Customer("Ali","Unknown");
        customer_arr.add(sdf);
        sdf = new Customer("Nobby","Unknown");
        customer_arr.add(sdf);
        sdf = new Customer("Bruno","Unknown");
        customer_arr.add(sdf);
        sdf = new Customer("Borat","Unknown");
        customer_arr.add(sdf);
        sdf = new Customer("Aladeen","Unknown");
        customer_arr.add(sdf);
        this.main_menu();
        
    }
    private void display_main_menu(){
        // System.out.println("Welcome to Mercury");
        System.out.println("1) Enter as Merchant");
        System.out.println("2) Enter as Customer");
        System.out.println("3) See user details");
        System.out.println("4) Company account balance");
        System.out.println("5) Exit");
    }
    private void display_choose_customer(){
        System.out.println("Choose customer");
        for(int i=0;i<customer_arr.size();i++){
            System.out.println(i+1+" "+customer_arr.get(i).get_customer_name());
        }
    }
    private void display_choose_merchant(){
        System.out.println("Choose merchant");
        for(int i=0;i<merchant_arr.size();i++){
            System.out.println(i+1+" "+merchant_arr.get(i).get_merchant_name());
        }
    }
    private void display_merchant_menu(){
        System.out.println("Merchant Menu");
        System.out.println("1) Add item");
        System.out.println("2) Edit item");
        System.out.println("3) Search by category");
        System.out.println("4) Add offer");
        System.out.println("5) Rewards won");
        System.out.println("6) Exit");
    }
    private void display_customer_menu(){
        System.out.println("Customer Menu");
        System.out.println("1) Search item");
        System.out.println("2) checkout cart");
        System.out.println("3) Rewards won");
        System.out.println("4) print latest orders");
        System.out.println("5) Exit");
    }
    private void main_menu(){
        String temp;
        int temp_int;
        while(!exit_application){
            this.display_main_menu();
            switch (scan.nextInt()) {
                case 1:
                    this.merchant_menu();
                    break;
                case 2:
                    this.customer_menu();
                    break;
                case 3:
                    System.out.print("Enter the category of the user (M or C) : ");
                    temp=scan.next();
                    if(temp.equals("M")){
                        for(int i=0;i<merchant_arr.size();i++){
                            System.out.println(i+1+" "+merchant_arr.get(i).get_merchant_name());
                        }
                        temp_int=scan.nextInt();
                        temp_int-=1;
                        for(int i=0;i<merchant_arr.size();i++){
                            if(i==temp_int){
                                merchant_arr.get(i).show_details();
                            }
                        }
                    }
                    else if(temp.equals("C")){
                        for(int i=0;i<customer_arr.size();i++){
                            System.out.println(i+1+" "+customer_arr.get(i).get_customer_name());
                        }
                        temp_int=scan.nextInt();
                        temp_int-=1;
                        for(int i=0;i<customer_arr.size();i++){
                            if(i==temp_int){
                                customer_arr.get(i).show_details();
                            }
                        }
                    }
                    else{
                        System.out.println("Invalid option, please try again");
                    }
                    break;

                case 4:
                    System.out.println("Company's current account balance : "+this.get_company_balance());
                    break;

                case 5:
                    exit_application=true;
                    System.out.println("----Thank You for Shopping with us----");
                    break;
            
                default:
                    System.out.println("Invalid option please try again");
                    break;
            }
        }
    }
    public void customer_menu(){
        if(this.customer_menu_flag){
            this.display_choose_customer();
            temp_int=scan.nextInt();
            temp_int-=1;
            for(int i=0;i<customer_arr.size();i++){
                if(temp_int==i){
                    System.out.println("Welcome "+customer_arr.get(i).get_customer_name());
                    def=customer_arr.get(i);
                }
            }
        }
        else{
            System.out.println("Welcome "+def.get_customer_name());
        }
        this.display_customer_menu();
        switch (scan.nextInt()) {
            case 1:
                this.customer_menu_flag=false;
                def.get_customer_searching(item_arr,this);
                this.customer_menu();
                break;
            case 2:
                this.customer_menu_flag=false;
                def.checkout_cart(this);
                this.customer_menu();
                break;
            case 3:
                this.customer_menu_flag=false;
                def.get_customer_reward();
                this.customer_menu();
                break;
            case 4:
                this.customer_menu_flag=false;
                def.print_recent_orders();
                this.customer_menu();
                break;
            case 5:
                this.customer_menu_flag=true;
                this.main_menu();
                // this.customer_menu();
                break;
        
            default:
                System.out.println("Invalid option, please try again.");
                break;
        }
    }
    private void merchant_menu(){
        
        if(this.merchant_menu_flag){
            this.display_choose_merchant();
            temp_int=scan.nextInt();
            temp_int-=1;
            for(int i=0;i<merchant_arr.size();i++){
                if(temp_int==i){
                    System.out.println("Welcome "+merchant_arr.get(i).get_merchant_name());
                    abc=merchant_arr.get(i);
                }
            }
        }
        else{
            System.out.println("Welcome "+abc.get_merchant_name());
        }
        this.display_merchant_menu();
        switch (scan.nextInt()) {
            case 1:
                this.merchant_menu_flag=false;
                abc.merchant_add_item(this);
                this.merchant_menu();
                break;
            case 2:
                this.merchant_menu_flag=false;
                abc.merchant_edit_item();
                this.merchant_menu();
                break;
            case 3:
                this.merchant_menu_flag=false;
                abc.searching(this.item_arr,this);
                this.merchant_menu();
                break;
            case 4:
                this.merchant_menu_flag=false;
                abc.merchant_add_offer();
                this.merchant_menu();
                break;
            case 5:
                this.merchant_menu_flag=false;
                abc.show_reward();
                this.merchant_menu();
                break;
            case 6:
                this.merchant_menu_flag=true;
                this.main_menu();
                break;
            default:
                System.out.println("Invalid option please try again");
                this.merchant_menu();
                break;
        }
    }
    public void show_details(check ck){
        ck.show_details();
    }
}

class Merchant implements check{

    private String merchant_name;
    private String merchant_address;
    private int merchant_contribution;
    private ArrayList<Item> merchant_item_arr;
    private int merchant_reward;
    private int merchant_slots;
    private int merchant_current_slots;
    private ArrayList<String> merchant_category_arr;
    Scanner scan = new Scanner(System.in);

    Merchant(String merchant_name,String merchant_address){
        this.merchant_slots=10;
        this.merchant_current_slots=0;
        this.merchant_name=merchant_name;
        this.merchant_address=merchant_address;
        this.merchant_contribution=0;
        this.merchant_category_arr = new ArrayList<String>();
        this.merchant_item_arr = new ArrayList<Item>();
    }
    @Override
    public void searching(ArrayList<Item> item_arr,Company comp){
        this.merchant_searching(item_arr);
    }
    @Override
    public void show_reward(){
        this.merchant_check_rewards();
    }
    public void merchant_searching(ArrayList<Item> item_arr){
        boolean temp=true;
        int choice=-1;
        String cat="";
        for(int i=0;i<item_arr.size();i++){
            temp=true;
            for(int j=0;j<merchant_category_arr.size();j++){
                if(item_arr.get(i).get_item_category().equals(merchant_category_arr.get(j))){
                    temp=false;
                }
            }
            if(temp){
                merchant_category_arr.add(item_arr.get(i).get_item_category());
            }
        }
        for(int i=0;i<merchant_category_arr.size();i++){
            System.out.println(i+1+") "+merchant_category_arr.get(i));
        }
        choice=scan.nextInt();
        cat=merchant_category_arr.get(choice-1);
        choice=1;
        Item abc;
        for(int i=0;i<item_arr.size();i++){
            if(item_arr.get(i).get_item_category().equals(cat)){
                abc=item_arr.get(i);
                System.out.println(choice+" "+abc.get_item_name()+" "+abc.get_item_price()+" "+abc.get_item_quantity()+" "+abc.get_item_offer()+" "+abc.get_item_category());
                choice++;
            }
        }

    }
    public void merchant_check_rewards(){
        int temp;
        temp=this.merchant_slots-10;
        System.out.println("Extra slots earned : "+temp);
    }
    public void merchant_add_offer(){
        Item abc;
        int temp;
        int temp_int;
        System.out.println("Choose item by code");
        for(int i=0;i<merchant_item_arr.size();i++){
            abc=merchant_item_arr.get(i);
            System.out.println(i+1+" "+abc.get_item_name()+" "+abc.get_item_price()+" "+abc.get_item_quantity()+" "+abc.get_item_offer()+" "+abc.get_item_category());
        }
        temp=scan.nextInt();
        temp_int=temp;
        abc=merchant_item_arr.get(temp-1);
        System.out.println("Choose offer :");
        System.out.println("1) Buy one get one");
        System.out.println("2) 25% off");
        temp=scan.nextInt();
        if(temp==1){
            abc.set_item_offer("Buy one get one");
        }
        else{
            abc.set_item_offer("25% off");
        }
        System.out.println(temp_int+" "+abc.get_item_name()+" "+abc.get_item_price()+" "+abc.get_item_quantity()+" "+abc.get_item_offer()+" "+abc.get_item_category());
    }
    public void merchant_edit_item(){
        int temp;
        Item abc;
        System.out.println("Choose item by code");
        for(int i=0;i<merchant_item_arr.size();i++){
            abc=merchant_item_arr.get(i);
            System.out.println(i+1+" "+abc.get_item_name()+" "+abc.get_item_price()+" "+abc.get_item_quantity()+" "+abc.get_item_offer()+" "+abc.get_item_category());
        }
        temp=scan.nextInt();
        temp-=1;
        System.out.println("Enter edit details");
        for(int i=0;i<merchant_item_arr.size();i++){
            if(temp==i){
                abc=merchant_item_arr.get(i);
                System.out.println("Item price :");
                abc.set_item_price(scan.nextInt());
                System.out.println("Item quantity :");
                abc.set_item_quantity(scan.nextInt());
                System.out.println(i+1+" "+abc.get_item_name()+" "+abc.get_item_price()+" "+abc.get_item_quantity()+" "+abc.get_item_offer()+" "+abc.get_item_category());
            }
        }

        
    }
    public void merchant_add_item(Company comp){
        if(this.merchant_current_slots<=this.merchant_slots){
            String item_name;
            int item_price;
            int item_quantity;
            String item_category;
            System.out.println("Enter the item details");
            System.out.println("Item name : ");
            item_name=scan.next();
            System.out.println("Item price : ");
            item_price=scan.nextInt();
            System.out.println("Item quantity :");
            item_quantity=scan.nextInt();
            System.out.println("Item category :");
            item_category=scan.next();
            Item temp = new Item(item_name,item_price,item_quantity,item_category,this);
            merchant_item_arr.add(temp);
            comp.item_arr.add(temp);
            for(int i=0;i<merchant_item_arr.size();i++){
                if(merchant_item_arr.get(i).get_item_name()==item_name){
                    temp=merchant_item_arr.get(i);
                    System.out.println(i+1+" "+temp.get_item_name()+" "+temp.get_item_price()+" "+temp.get_item_quantity()+" "+temp.get_item_offer()+" "+temp.get_item_category());
                }
            }
            
            // System.out.println("Enter the item details");
            // System.out.println("Item name : ");
            // item_name=scan.next();
            // System.out.println("Item price : ");
            // item_price=scan.nextInt();
            // System.out.println("Item quantity :");
            // item_quantity=scan.nextInt();
            // System.out.println("Item category :");
            // item_category=scan.next();
            // temp = new Item(item_name,item_price,item_quantity,item_category,this);
            // merchant_item_arr.add(temp);
            // for(int i=0;i<merchant_item_arr.size();i++){
            //     if(merchant_item_arr.get(i).get_item_name()==item_name){
            //         temp=merchant_item_arr.get(i);
            //         System.out.println(i+1+" "+temp.get_item_name()+" "+temp.get_item_price()+" "+temp.get_item_quantity()+" "+temp.get_item_offer()+" "+temp.get_item_category());
            //     }
            // }
            // String item_category;
            this.merchant_current_slots++;
        }
        else{
            System.out.println("Not enough slots.");
        }

    }
    public String get_merchant_name(){
        return this.merchant_name;
    }
    public String get_merchant_address(){
        return this.merchant_address;
    }
    public int get_merchant_contribution(){
        return this.merchant_contribution;
    }
    @Override
    public void show_details(){
        this.show_merchant_details();
    }
    public void show_merchant_details(){
        System.out.println("Merchant name : "+this.merchant_name);
        System.out.println("Merchant address : "+this.merchant_address);
        System.out.println("Merchant contribution to the company : "+this.merchant_contribution);
    }

}

class Customer implements check{
    private String customer_name;
    private String customer_address;
    private int customer_no_of_orders;
    private Account customer_main_account;
    private Account customer_reward_account;
    private ArrayList<String> customer_category_arr;
    private int purchase_count;

    private ArrayList<Item> customer_cart;
    Scanner scan = new Scanner(System.in);
    private ArrayList<Item> recent_orders;

    Customer(String customer_name, String customer_address){
        this.recent_orders=new ArrayList<Item>();
        this.check=true;
        this.customer_name=customer_name;
        this.customer_address=customer_address;
        this.customer_no_of_orders=0;
        this.customer_main_account=new Account(100);
        this.customer_reward_account=new Account();
        this.purchase_count=0;
        this.customer_cart=new ArrayList<Item>();
        this.customer_category_arr = new ArrayList<String>();
    }

    @Override
    public void searching(ArrayList<Item> item_arr,Company comp){
        this.get_customer_searching(item_arr,comp);
    }
    @Override
    public void show_reward(){
        this.get_customer_reward();
    }
    public void print_recent_orders(){
        System.out.println("size of recent order"+this.recent_orders.size());
        if(this.recent_orders.size()<=10){
            for(int i=0;i<this.recent_orders.size();i++){
                // System.out.println("i "+i);
                if(this.recent_orders.get(i).get_item_offer().equals("25% off")){
                    System.out.println("Bought item : "+this.recent_orders.get(i).get_item_name()+" quantity : "+this.recent_orders.get(i).get_customer_item_quantity()+" for Rs "+((this.recent_orders.get(i).get_item_price()*3)/4)*this.recent_orders.get(i).get_customer_item_quantity() +" from Merchat "+this.recent_orders.get(i).get_item_owner());    
                }
                else{
                    System.out.println("Bought item : "+this.recent_orders.get(i).get_item_name()+" quantity : "+this.recent_orders.get(i).get_customer_item_quantity()+" for Rs "+this.recent_orders.get(i).get_item_price()*this.recent_orders.get(i).get_customer_item_quantity()+" from Merchat "+this.recent_orders.get(i).get_item_owner());
                }
            }
        }
        else{
            int ptr=this.recent_orders.size();
            for(int i=0;i<10;i++){
                if(this.recent_orders.get(ptr).get_item_offer().equals("25% off")){
                    System.out.println("Bought item : "+this.recent_orders.get(ptr).get_item_name()+" quantity : "+this.recent_orders.get(ptr).get_customer_item_quantity()+" for Rs "+((this.recent_orders.get(ptr).get_item_price()*3)/4)*this.recent_orders.get(i).get_customer_item_quantity() +" from Merchat "+this.recent_orders.get(ptr).get_item_owner());    
                }
                else{
                    System.out.println("Bought item : "+this.recent_orders.get(ptr).get_item_name()+" quantity : "+this.recent_orders.get(ptr).get_customer_item_quantity()+" for Rs "+this.recent_orders.get(ptr).get_item_price()*this.recent_orders.get(i).get_customer_item_quantity()+" from Merchat "+this.recent_orders.get(ptr).get_item_owner());
                }
                ptr--;
            }
        }
    }
    public void checkout_cart(Company comp){
        int s = this.customer_cart.size();
        Item abc;
        int item_quantity;
        int final_price=0;
        for(int i=0;i<s;i++){
            abc=this.customer_cart.get(i);
            item_quantity=abc.get_customer_item_quantity();
            final_price=abc.get_item_price();
            if(abc.get_item_offer().equals("25% off")){
                final_price=(abc.get_item_price()*3)/4;
            }
            if((this.get_customer_main_account_balance()+this.get_customer_reward_account_balance())>=(final_price*item_quantity)){
                if(this.get_customer_main_account_balance()>=(final_price*item_quantity)){
                    this.customer_main_account.set_balance(this.customer_main_account.get_balance()-(final_price*item_quantity));
                }
                else{
                    int b=this.get_customer_main_account_balance();
                    b=(final_price*item_quantity)-b;
                    this.get_customer_reward_account().set_balance(this.get_customer_reward_account_balance()-b);
                }

                System.out.println("Item successfully bought");
                this.purchase_count++;
                if(this.purchase_count==5){
                    this.get_customer_reward_account().add_balance(10);
                    this.purchase_count=0;
                }
                comp.add_company_contribution(final_price*item_quantity);
                this.recent_orders.add(this.customer_cart.get(i));
                // System.out.println("add done 549");
            }
            else{
                System.out.println("Insufficient balance,please try again");
                break;
            }
        }
        this.customer_cart=new ArrayList<Item>();
        // for(int i=0;i<s;i++){
        //     this.customer_cart.remove(i);
        // }
    }
    public void get_customer_searching(ArrayList<Item> item_arr,Company comp){
        boolean temp=true;
        int choice=-1;
        String cat="";
        for(int i=0;i<item_arr.size();i++){
            temp=true;
            for(int j=0;j<customer_category_arr.size();j++){
                if(item_arr.get(i).get_item_category().equals(customer_category_arr.get(j))){
                    temp=false;
                }
            }
            if(temp){
                customer_category_arr.add(item_arr.get(i).get_item_category());
            }
        }
        for(int i=0;i<customer_category_arr.size();i++){
            System.out.println(i+1+") "+customer_category_arr.get(i));
        }
        choice=scan.nextInt();
        cat=customer_category_arr.get(choice-1);
        choice=1;
        Item abc;
        abc=item_arr.get(0);
        System.out.println("Choose item by code : ");
        for(int i=0;i<item_arr.size();i++){
            if(item_arr.get(i).get_item_category().equals(cat)){
                abc=item_arr.get(i);
                System.out.println(choice+" "+abc.get_item_name()+" "+abc.get_item_price()+" "+abc.get_item_quantity()+" "+abc.get_item_offer()+" "+abc.get_item_category());
                choice++;
            }
        }
        System.out.println("Enter item code :");
        int item_code=scan.nextInt();
        System.out.println("Enter item quantity : ");
        int item_quantity=scan.nextInt();
        choice=1;
        for(int i=0;i<item_arr.size();i++){
            if(item_arr.get(i).get_item_category().equals(cat)){
                if(choice==item_code){
                    abc=item_arr.get(i);
                }
                choice++;
            }
        }
        System.out.println("Choose method of transaction");
        System.out.println("1) Buy item");
        System.out.println("2) Add item to cart");
        System.out.println("3) Exit");
        switch (scan.nextInt()) {
            case 1:
                this.customer_buy_item(abc,item_quantity,comp);
                break;
            case 2:
                this.customer_add_to_cart(abc,item_quantity);
                System.out.println("Item added to cart");
                break;
            case 3:
                comp.customer_menu();
                break;
        
            default:
                System.out.println("Invalid option please try again");
                break;
        }
        
    }
    public void customer_add_to_cart(Item abc,int item_quantity){
        this.customer_cart.add(abc);
        abc.set_customer_item_quantity(item_quantity);      
        if(abc.get_item_offer().equals("Buy one get one")){
            abc.set_item_quantity(abc.get_item_quantity()-(2*item_quantity));    
        }
        else{
            abc.set_item_quantity(abc.get_item_quantity()-item_quantity);
        }
    }
    public void customer_buy_item(Item abc,int item_quantity,Company comp){
        int final_price=abc.get_item_price();
        if(abc.get_item_offer().equals("25% off")){
            final_price=(abc.get_item_price()*3)/4;
        }
        if((this.get_customer_main_account_balance()+this.get_customer_reward_account_balance())>=(final_price*item_quantity)){
            if(this.get_customer_main_account_balance()>=(final_price*item_quantity)){
                this.customer_main_account.set_balance(this.customer_main_account.get_balance()-(final_price*item_quantity));
            }
            else{
                int b=this.get_customer_main_account_balance();
                b=(final_price*item_quantity)-b;
                this.get_customer_reward_account().set_balance(this.get_customer_reward_account_balance()-b);
            }

            System.out.println("Item successfully bought");
            this.purchase_count++;
            if(this.purchase_count==5){
                this.get_customer_reward_account().add_balance(10);
                this.purchase_count=0;
            }
            comp.add_company_contribution(final_price*item_quantity);
            if(abc.get_item_offer().equals("Buy one get one")){
                abc.set_item_quantity(abc.get_item_quantity()-(2*item_quantity));
                abc.set_customer_item_quantity(2*item_quantity);  
            }
            else{
                abc.set_item_quantity(abc.get_item_quantity()-item_quantity);
                abc.set_customer_item_quantity(item_quantity);
            }
            this.recent_orders.add(abc);
        }
        else{
            System.out.println("Insufficient balance,please try again");
        }
    }
    public Account get_customer_reward_account(){
        return this.customer_reward_account;
    }
    public void get_customer_reward(){
        System.out.println("Money from reward program : "+this.customer_reward_account.get_balance());
    }
    public int get_customer_main_account_balance(){
        return this.customer_main_account.get_balance();
    }
    public int get_customer_reward_account_balance(){
        return this.customer_reward_account.get_balance();
    }
    public int get_customer_no_of_orders(){
        return this.customer_no_of_orders;
    }
    public String get_customer_name(){
        return this.customer_name;
    }
    public String get_customer_address(){
        return this.customer_address;
    }
    @Override
    public void show_details(){
        this.show_customer_details();
    }
    public void show_customer_details(){
        System.out.println("Customer name : "+this.customer_name);
        System.out.println("Customer address : "+this.customer_address);
        System.out.println("Number of orders placed : "+this.customer_no_of_orders);
    }

}

class Account{

    private int balance;

    Account(){
        this.balance=0;
    }
    Account(int d){
        this.balance=d;
    }

    public void add_balance(int d){
        this.balance+=d;
    }
    public void set_balance(int d){
        this.balance=d;
    }
    public int get_balance(){
        return this.balance;
    }

}

class Item{
    private String item_name;
    private int item_price;
    private int item_quantity;
    private String item_category;
    private String item_offer="None";
    private Merchant item_owner;
    private int customer_item_quantity=0;

    Item(String item_name,int item_price,int item_quantity,String item_category,Merchant abc){
        this.item_owner=abc;
        this.item_name=item_name;
        this.item_price=item_price;
        this.item_quantity=item_quantity;
        this.item_category=item_category;
        this.item_offer=item_offer;
    }
    public String get_item_name(){
        return this.item_name;
    }
    public String get_item_owner(){
        return this.item_owner.get_merchant_name();
    }
    public int get_customer_item_quantity(){
        return this.customer_item_quantity;
    }
    public void set_customer_item_quantity(int d){
        this.customer_item_quantity=d;
    }
    public int get_item_price(){
        return this.item_price;
    }
    public void set_item_price(int price){
        this.item_price=price;
    }
    public int get_item_quantity(){
        return this.item_quantity;
    }
    public void set_item_quantity(int quantity){
        this.item_quantity=quantity;
    }
    public String get_item_category(){
        return this.item_category;
    }
    public String get_item_offer(){
        return this.item_offer;
    }
    public void set_item_offer(String abc){
        this.item_offer=abc;
    }
}


public class e_commerce_application{

    private static Company company;
    private static String company_name;

    public static void main(String[] args) {

        // System.out.println("Enter the name of the Company");
        // company_name=scan.next();
        company_name="Mercury";
        company=new Company(company_name);
        company.display_welcome();
        company.start_application();
    }

}