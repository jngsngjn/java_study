package design.patterns.template_method;

public class AppMain {
    public static void main(String[] args) {
        Beverage coffee = new Coffee();
        coffee.prepareRecipe();

        System.out.println("------");

        Beverage tea = new Tea();
        tea.prepareRecipe();
    }
}