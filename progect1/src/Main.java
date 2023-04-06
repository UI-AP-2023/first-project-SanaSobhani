import controller.AdminController;
import controller.CommodityController;
import controller.CustomerController;
import model.commodity.*;
import model.user.*;
import view.AdminView;
import view.CommodityView;
import view.CustomerView;
import view.MainView;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) {
      MainView mainView = new MainView();
      mainView.mainView();
    }}