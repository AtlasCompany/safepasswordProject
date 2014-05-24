import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProcessPass extends HttpServlet {
    public String pass;
    public int mark;
    public String suggestionPass;
    public int upper;
    public int lower;
    public int num;
    public int etc;
    public String[] chars;
    public ArrayList<String> alpha = new ArrayList<String>();
    public String crackTime;
    public int lengthOfCharSet;

    public void init() {
        alpha.add(0, "a");
        alpha.add(1, "b");
        alpha.add(2, "c");
        alpha.add(3, "d");
        alpha.add(4, "e");
        alpha.add(5, "f");
        alpha.add(6, "g");
        alpha.add(7, "h");
        alpha.add(8, "i");
        alpha.add(9, "j");
        alpha.add(10, "k");
        alpha.add(11, "l");
        alpha.add(12, "m");
        alpha.add(13, "n");
        alpha.add(14, "o");
        alpha.add(15, "p");
        alpha.add(16, "q");
        alpha.add(17, "r");
        alpha.add(18, "s");
        alpha.add(19, "t");
        alpha.add(20, "u");
        alpha.add(21, "v");
        alpha.add(22, "w");
        alpha.add(23, "x");
        alpha.add(24, "y");
        alpha.add(25, "z");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        mark = 0;
        lower = 0;
        upper = 0;
        num = 0;
        etc = 0;
        suggestionPass = "";
        crackTime = "";

        pass = request.getParameter("pass");
        if (pass != null && pass != "") {
//            savePass(pass);

            chars = pass.split("");

            ArrayList<Integer> upperIndex = new ArrayList<Integer>();
            ArrayList<Integer> lowerIndex = new ArrayList<Integer>();

            for (int counter = 1; counter < chars.length; counter++) {
                if (chars[counter].hashCode() >= 97 && chars[counter].hashCode() <= 122) {
                    lowerIndex.add(lower, counter);
                    lower++;
                } else if (chars[counter].hashCode() >= 65 && chars[counter].hashCode() <= 90) {
                    upperIndex.add(upper, counter);
                    upper++;
                } else if (chars[counter].hashCode() >= 49 && chars[counter].hashCode() <= 57) {
                    num++;
                } else {
                    etc++;
                }
            }

            markingPass(pass);

            if (mark <= 90)
                suggestionPass(pass, chars, lowerIndex, upperIndex);

            HttpSession session = request.getSession(true);
            session.setAttribute("mark", mark);
            session.setAttribute("suggestion", suggestionPass);
            session.setAttribute("crackTime", crackTime);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resultShow.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

    public void markingPass(String pass) {
        lengthOfCharSet = 0;

        if (lower != 0)
            lengthOfCharSet = lengthOfCharSet + 26;
        if (upper != 0)
            lengthOfCharSet = lengthOfCharSet + 26;
        if (num != 0)
            lengthOfCharSet = lengthOfCharSet + 10;
        if (etc != 0)
            lengthOfCharSet = lengthOfCharSet + 8;

        long time = (long) (Math.pow(lengthOfCharSet, (chars.length - 1))) / 500000;
        crackTime = "Instant";
        mark = 10;
        if (time > 60) {
            time = time / 60;
            crackTime = time + "Minutes";
            if (time <= 30)
                mark = 15;
            else if (time > 30 && time < 60)
                mark = 20;
            if (time > 60) {
                time = time / 60;
                crackTime = time + "Hours";
                if (time <= 10)
                    mark = 25;
                else if (time > 10)
                    mark = 30;
                if (time > 24) {
                    time = time / 24;
                    crackTime = time + "Day";
                    if (time <= 5)
                        mark = 40;
                    else if (time > 5 && time <= 10)
                        mark = 45;
                    else if (time > 10 && time <= 30)
                        mark = 50;
                    else if (time > 30 && time <= 90)
                        mark = 60;
                    else if (time > 90 && time <= 180)
                        mark = 80;
                    else if (time > 180 && time <= 364)
                        mark = 90;
                    if (time > 365) {
                        time = time / 365;
                        crackTime = time + "Years";
                        if (time < 3)
                            mark = 90;
                        else if (time > 3 && time <= 50)
                            mark = 95;
                        else if (time > 50 && time < 100)
                            mark = 99;
                        else if (time >= 100)
                            mark = 100;
                    }
                }
            }
        }
    }

    public void savePass(String pass) {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "test";
        String driver = "org.mysql.jdbc.JDBCDriver";
        String userName = "root";
        String password = "";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url + dbName, userName, password);
            Statement st = conn.createStatement();
            st.execute("INSERT INTO safepassword (pass) VALUES(" + pass + ");");
//            st.setString(1, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void suggestionPass(String pass, String[] chars, ArrayList<Integer> lowerIndex, ArrayList<Integer> upperIndex) {
        int param = 0;
        suggestionPass = pass;

        if (upper == 0) {
            if (lower <= 6 && lower > 1) {
                int temp = (int) lower / 2;
                for (int j = 1; j <= temp; j++) {
                    int index = ((int) (Math.random() * 100)) % lower;
                    chars[lowerIndex.get(index)] = chars[lowerIndex.get(index)].toUpperCase();
                }
                suggestionPass = makeString(chars);

            } else if (lower <= 1) {
                String tempUpper = "";
                for (int i = 0; i < 3; i++) {
                    int alphaRandomIndex = (int) (Math.random() * 1000);
                    alphaRandomIndex = alphaRandomIndex % 26;
                    tempUpper = alpha.get(alphaRandomIndex).toUpperCase();
                    suggestionPass = tempUpper + suggestionPass;
                }
            } else if (lower > 6) {
                for (int j = 1; j <= 3; j++) {
                    int index = ((int) (Math.random() * 100)) % lower;
                    chars[lowerIndex.get(index)] = chars[lowerIndex.get(index)].toUpperCase();
                }
                suggestionPass = makeString(chars);
            }
        }

        if (lower == 0) {
            if (upper <= 6 && upper > 1) {
                int temp2 = (int) upper / 2;
                for (int j = 1; j <= temp2; j++) {
                    int index2 = ((int) (Math.random() * 100)) % upper;
                    chars[upperIndex.get(index2)] = chars[upperIndex.get(index2)].toLowerCase();
                }
                suggestionPass = makeString(chars);

            } else if (upper <= 1) {
                String tempLower = "";
                for (int i = 0; i < 3; i++) {
                    int alphaRandomIndex = (int) (Math.random() * 1000);
                    alphaRandomIndex = alphaRandomIndex % 26;
                    tempLower = alpha.get(alphaRandomIndex);
                    suggestionPass = tempLower + suggestionPass;
                }
            } else if (upper > 6) {
                for (int j = 1; j <= 3; j++) {
                    int index2 = ((int) (Math.random() * 100)) % upper;
                    chars[upperIndex.get(index2)] = chars[upperIndex.get(index2)].toLowerCase();
                }
                suggestionPass = makeString(chars);
            }
        }

        if (etc == 0) {
            param = (int) (Math.random() * 10);

            switch (param) {
                case 0: {
                    suggestionPass = suggestionPass + "!" + ((int) Math.random() * 100);
                    break;
                }
                case 1: {
                    suggestionPass = suggestionPass + "!" + (param * ((int) Math.random() * 100));
                    break;
                }
                case 2: {
                    suggestionPass = suggestionPass + "@" + (param * ((int) Math.random() * 100));
                    break;
                }
                case 3: {
                    suggestionPass = suggestionPass + "#" + (param * ((int) Math.random() * 100));
                    break;
                }
                case 4: {
                    suggestionPass = suggestionPass + "$" + (param * ((int) Math.random() * 100));
                    break;
                }
                case 5: {
                    suggestionPass = suggestionPass + "%" + (param * ((int) Math.random() * 100));
                    break;
                }
                case 6: {
                    suggestionPass = suggestionPass + "&" + (param * ((int) Math.random() * 100));
                    break;
                }
                case 7: {
                    suggestionPass = suggestionPass + "*" + (param * ((int) Math.random() * 100));
                    break;
                }
                case 8: {
                    suggestionPass = suggestionPass + "(" + (param * ((int) Math.random() * 100));
                    break;
                }
                case 9: {
                    suggestionPass = suggestionPass + ")" + (param * ((int) Math.random() * 100));
                    break;
                }
            }
        }

        if (num == 0) {
            String random = "";
            for (int i = 0; i < 3; i++) {
                random = random + (int) (Math.random() * 10);
            }
            suggestionPass = suggestionPass + random;
        }

        while (suggestionPass.length()<8){
            int alphaRandomIndex = (int) (Math.random() * 1000);
            alphaRandomIndex = alphaRandomIndex % 26;
            suggestionPass = alpha.get(alphaRandomIndex).toUpperCase() + suggestionPass;
        }

    }

    public String makeString(String[] chars) {
        String str = "";
        for (int i = 0; i < chars.length; i++) {
            str = str + chars[i];
        }
        return str;
    }
}
