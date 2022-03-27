package mathtest;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.util.Scanner;

/**
 * @author noname
 * @version 3
 * @see SomeTools
 */
public abstract class SomeTools {

    public static <e> int Array_element_lookup(e[] a, e b) {
        assert a!=null;
        assert b!=null;
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals(b)) {
                return i;
            }
        }
        return -1;
    }
    /*
    @Deprecated
    public static int Array_element_lookup(int[] a, int b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b) {
                return i;
            }
        }
        return -1;
    }

    @Deprecated
    public static int Array_element_lookup(double[] a, double b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b) {
                return i;
            }
        }
        return -1;
    }

    @Deprecated
    public static int Array_element_lookup(String[] a, String b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null ? b == null : a[i].equals(b)) {
                return i;
            }
        }
        return -1;
    }*/

    public static <e extends Number> e Array_minimum_lookup(e[] a) {
        assert a!=null;
        e b = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i].doubleValue() < b.doubleValue()) {
                b = a[i];
            }
        }
        return b;
    }

    public static <e extends Number> e Array_maximum_lookup(e[] a) {
        assert a!=null;
        e b = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i].doubleValue() > b.doubleValue()) {
                b = a[i];
            }
        }
        return b;
    }
    /*
    @Deprecated
    public static int Array_minimum_lookup(int[] a) {
        int b = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < b) {
                b = a[i];
            }
        }
        return b;
    }

    @Deprecated
    public static int Array_maximum_lookup(int[] a) {
        int b = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > b) {
                b = a[i];
            }
        }
        return b;
    }

    @Deprecated
    public static double Array_minimum_lookup(double[] a) {
        double b = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < b) {
                b = a[i];
            }
        }
        return b;
    }

    @Deprecated
    public static double Array_maximum_lookup(double[] a) {
        double b = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > b) {
                b = a[i];
            }
        }
        return b;
    }*/
    
    public static boolean isInteger(String a) {
        assert a!=null;
        boolean b = false;
        for (int i = 0; i < a.length(); i++) {
            for (String j:new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}) {
                if (a.substring(i, i + 1).equals(j)) {
                    b = true;
                    break;
                } else {
                    b = false;
                }
            }
            if (!b) {
                if (i == 0 && "-".equals(a.substring(0, 1))) {
                    b = true;
                } else {
                    break;
                }
            }
        }
        return b;
    }

    public static boolean isDecimal(String a) {
        assert a!=null;
        boolean b = false;
        boolean c = false;
        for (int i = 0; i < a.length(); i++) {
            for (String j:new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}) {
                if (a.substring(i, i + 1).equals(j)) {
                    b = true;
                    break;
                } else {
                    b = false;
                }
            }
            if (!b) {
                if (i == 0 && "-".equals(a.substring(0, 1))) {
                    b = true;
                } else if (!c && ".".equals(a.substring(i, i + 1))) {
                    b = true;
                    c = true;
                } else {
                    break;
                }
            }
        }
        return b;
    }

    public static Object customOptions(String prompt, String[] options, int return_type) {
        assert options!=null;
        assert return_type>=0&&return_type<=1;
        String c;
        int a;
        for (;;) {
            if (prompt != null) {
                System.out.println(prompt);
            }
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + "." + options[i]);
            }
            System.out.print("Choose(选择):");
            c = new Scanner(System.in).nextLine();
            a = Array_element_lookup(options, c);
            if (a != -1) {
                return return_type == 0 ? a : options[a];
            } else {
                if (isInteger(c)) {
                    if (Integer.parseInt(c) - 1 >= 0 && Integer.parseInt(c) - 1 < options.length) {
                        return return_type == 0 ? Integer.parseInt(c) - 1 : options[Integer.parseInt(c) - 1];
                    } else {
                        System.out.println("This option is not available, please re-select(没有这个选项，请重新选择)");
                    }
                } else {
                    System.out.println("This option is not available, please re-select(没有这个选项，请重新选择)");
                }
            }
        }
    }

    public static int enterInteger(boolean whetherPrompt) {
        return enterInteger(Integer.MIN_VALUE, true, Integer.MAX_VALUE, true, whetherPrompt);
    }

    public static int enterInteger(int value, boolean equal, boolean isMin, boolean whetherPrompt) {
        return enterInteger(isMin ? value : Integer.MIN_VALUE, isMin ? equal : true, isMin ? Integer.MAX_VALUE : value, isMin ? true : equal, whetherPrompt);
    }

    public static int enterInteger(int minimum, boolean equal1, int maximum, boolean equal2, boolean whetherPrompt) {
        if (minimum < Integer.MIN_VALUE) {
            minimum = Integer.MIN_VALUE;
            equal1 = true;
        }
        if (maximum > Integer.MAX_VALUE) {
            maximum = Integer.MAX_VALUE;
            equal2 = true;
        }
        if (maximum < minimum) {
            maximum = Integer.MAX_VALUE;
            minimum = Integer.MIN_VALUE;
            equal1 = true;
            equal2 = true;
        }
        for (;;) {
            int a;
            while (true) {
                String c = new Scanner(System.in).nextLine();
                if (isInteger(c)) {
                    a = Integer.parseInt(c);
                    break;
                } else if (whetherPrompt) {
                    System.out.println("An decimal is required. Please retype(需要小数，请重新输入)");
                }
            }
            if ((equal1 ? a >= minimum : a > minimum) && (equal2 ? a <= maximum : a < maximum)) {
                return a;
            } else if (whetherPrompt) {
                System.out.println("The required number is in " + (equal1 ? "[ " : "( ") + minimum + " , " + maximum + (equal2 ? " ]" : " )") + ", please enter again.");
            }
        }
    }

    public static double enterDecimal(boolean whetherPrompt) {
        return enterDecimal(-Double.MIN_VALUE, true, Double.MAX_VALUE, true, whetherPrompt);
    }

    public static double enterDecimal(double value, boolean equal, boolean isMin, boolean whetherPrompt) {
        return enterDecimal(isMin ? value : -Double.MIN_VALUE, isMin ? equal : true, isMin ? Double.MAX_VALUE : value, isMin ? true : equal, whetherPrompt);
    }

    public static double enterDecimal(double minimum, boolean equal1, double maximum, boolean equal2, boolean whetherPrompt) {
        if (minimum < -Double.MIN_VALUE) {
            minimum = -Double.MIN_VALUE;
            equal1 = true;
        }
        if (maximum > Double.MAX_VALUE) {
            maximum = Double.MAX_VALUE;
            equal2 = true;
        }
        if (maximum < minimum) {
            maximum = Double.MAX_VALUE;
            minimum = -Double.MIN_VALUE;
            equal1 = true;
            equal2 = true;
        }
        for (;;) {
            double a;
            while (true) {
                String c = new Scanner(System.in).nextLine();
                if (isDecimal(c)) {
                    a = Double.parseDouble(c);
                    break;
                } else if (whetherPrompt) {
                    System.out.println("An decimal is required. Please retype(需要小数，请重新输入)");
                }
            }
            if ((equal1 ? a >= minimum : a > minimum) && (equal2 ? a <= maximum : a < maximum)) {
                return a;
            } else if (whetherPrompt) {
                System.out.println("The required number is in " + (equal1 ? "[ " : "( ") + minimum + " , " + maximum + (equal2 ? " ]" : " )") + ", please enter again.");
            }
        }
    }

    public static String restrictUserInput(int shortest, int longest, boolean whetherPrompt) {
        String a;
        while (true) {
            a = new Scanner(System.in).nextLine();
            if ((shortest == -1 ? true : a.length() >= shortest) && (longest == -1 ? true : a.length() <= longest)) {
                return a;
            } else if (whetherPrompt) {
                System.out.println((shortest == -1 ? "" : "Minimum " + shortest + " character" + (shortest > 1 ? "s" : "") + (longest == -1 ? "" : " and ")) + (longest == -1 ? "" : (shortest == -1 ? "M" : "m") + "aximum " + longest + " character" + (longest > 1 ? "s" : "")) + " are required. Please re-enter.");
            }
        }
    }

    public static String restrictUserInput(String[] character, boolean isWhiteList, boolean whetherPrompt) {
        assert character!=null;
        String a;
        boolean b;
        while (true) {
            b = false;
            a = new Scanner(System.in).nextLine();
            if (isWhiteList ? isWhiteList(a, character) : !isWhiteList(a, character)) {
                return a;
            } else if (whetherPrompt) {
                System.out.println((isWhiteList ? "Required is the character in " : "Cannot have the character in ") + java.util.Arrays.toString(character) + ", please enter again");
            }
        }
    }

    public static boolean isWhiteList(String a, String[] character) {
        assert a!=null;
        assert character!=null;
        boolean b = false;
        for (int i = 0; i < a.length(); i++) {
            for (String character1 : character) {
                if (a.substring(i, i + 1).equals(character1)) {
                    b = true;
                    break;
                } else {
                    b = false;
                }
            }
            if (!b) {
                break;
            }
        }
        return b;
    }

    public static String restrictUserInput(int shortest, int longest, String[] character, boolean isWhiteList, boolean whetherPrompt) {
        assert character!=null;
        assert shortest>=0;
        String a;
        boolean b;
        while (true) {
            b = false;
            a = new Scanner(System.in).nextLine();
            if ((shortest == -1 ? true : a.length() >= shortest) && (longest == -1 ? true : a.length() <= longest)) {
                if (isWhiteList ? isWhiteList(a, character) : !isWhiteList(a, character)) {
                    return a;
                } else if (whetherPrompt) {
                    System.out.println((isWhiteList ? "Required is the character in " : "Cannot have the character in ") + java.util.Arrays.toString(character) + ", please enter again");
                }
            } else if (whetherPrompt) {
                System.out.println((shortest == -1 ? "" : "Minimum " + shortest + " character" + (shortest > 1 ? "s" : "") + (longest == -1 ? "" : " and ")) + (longest == -1 ? "" : (shortest == -1 ? "M" : "m") + "aximum " + longest + " character" + (longest > 1 ? "s" : "")) + " are required. Please re-enter.");
            }
        }
    }

    public static File fileChooser(String[][] fileType) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return true;
            }

            @Override
            public String getDescription() {
                return "all file(*.*)";
            }
        });
        for (final String[] fileEName : fileType) {
            fileChooser.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    return file.getName().endsWith(fileEName[0]) || file.isDirectory();
                }

                @Override
                public String getDescription() {
                    return fileEName[1];
                }
            });
        }
        fileChooser.showDialog(null, null);
        return fileChooser.getSelectedFile();
    }
    public static File fileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showDialog(null, null);
        return fileChooser.getSelectedFile();
    }
    public static String desktopPath() {
        return System.getProperty("user.home") + System.getProperty("file.separator") + "desktop" + System.getProperty("file.separator");
    }
}
