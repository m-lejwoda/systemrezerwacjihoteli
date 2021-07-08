package pl.systemrezerwacji;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.util.Vector;

import static javax.swing.JOptionPane.showMessageDialog;

public class CardLayoutDemo implements ItemListener {
    JPanel cards; //a panel that uses CardLayout
    final static String BUTTONPANEL = "Card with JButtons";
    final static String TEXTPANEL = "Card with JTextField";
    final static String CART3 = "Card number 3";
    public void addComponentToPane(Container pane) throws SQLException {
//        Connection con = null;
        String path = "jdbc:sqlite:/System rezerwacji hoteli/bazasystemu.db";
        Connection con = DriverManager.getConnection(path);
        Statement stmt = con.createStatement();
        String query = "SELECT * FROM Hotel";
        Vector<Vector<String>> doublevector = new Vector<Vector<String>>();
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()){
            Vector<String> singlevector = new Vector<String>();
            singlevector.add(rs.getString("nazwa"));
            singlevector.add(rs.getString("srednia_cena_pokoju"));
            singlevector.add(rs.getString("liczba_wolnych_pokoi"));
            singlevector.add(rs.getString("liczba_gwiazdek"));
            doublevector.add(singlevector);
        }
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel comboBoxPane = new JPanel(new GridBagLayout());
        JLabel maintitle = new JLabel("Rezerwator hoteli");
        maintitle.setFont(maintitle.getFont().deriveFont(32.0f));
        JLabel citytitle = new JLabel("Wpisz swoją miejscowość");
        JTextField citytext = new JTextField();
        citytext.setPreferredSize(new Dimension(200,20));
        JButton acceptcity = new JButton("Wyszukaj");
        JButton user = new JButton("Zwykły użytkownik");
        user.setEnabled(false);
        JButton hoteluser = new JButton("Wlasciciel hotelu");
        JButton gotoreservationdata = new JButton("Przejdź dalej");
        JButton gotoreservationowner = new JButton("Przejdź dalej");
        JButton addrooms = new JButton("Dodaj pokoje");
        JButton addhotel = new JButton("Dodaj hotel");
        JButton displayreservation = new JButton("Wyświetl rezerwacje");
        JButton gobacktocard1 = new JButton("Cofnij");
        JButton gobacktocard11 = new JButton("Cofnij");
        JButton gobacktocard12= new JButton("Cofnij");
        JButton gobacktocard13= new JButton("Cofnij");
        JButton gobacktocard14= new JButton("Cofnij");
        JLabel namelabel =  new JLabel("Podaj Imię");
        JTextField nametext = new JTextField();
        nametext.setPreferredSize(new Dimension(100,20));
        JLabel lastnamelabel =  new JLabel("Podaj Nazwisko");
        JTextField lastnametext = new JTextField();
        lastnametext.setPreferredSize(new Dimension(100,20));
        JLabel datestartlabel =  new JLabel("Podaj date rozpoczynajaca rezerwacje dd/mm/yyyy");
        JTextField datestart = new JTextField();
        JLabel dateendlabel =  new JLabel("Podaj date kończącą rezerwacje dd/mm/yyyy");
        JTextField dateend = new JTextField();
        JLabel ownerlabel = new JLabel("Witaj właścicielu hotelu");
        JLabel roomnamelabel = new JLabel("Nazwa pokoju ");
        JTextField roomnametext = new JTextField();
        roomnametext.setPreferredSize(new Dimension(200,20));
        JLabel roomnpricelabel = new JLabel("Cena pokoju");
        JTextField roompricetext = new JTextField();
        roompricetext.setPreferredSize(new Dimension(200,20));
        JLabel roomnumberlabel = new JLabel("Liczba pokoi");
        JTextField roomnumbertext = new JTextField();
        JButton addroomtodatabase = new JButton("Dodaj pokój do bazy danych");
        roomnumbertext.setPreferredSize(new Dimension(200,20));
        JButton backtoownertable = new JButton("Wróć do wyboru hoteli");
        JButton displayhoteldescription = new JButton("Wyświetl opinie hotelu");
        JButton addhoteldescription = new JButton("Dodaj opinię hotelowi");
        Vector<String> columnvector = new Vector<String>();
        JLabel adddescriptionlabel = new JLabel("Dodaj Opinie o hotelu");
        JTextArea adddescription = new JTextArea();
        JButton acceptdescription = new JButton("Dodaj opinie");
        DefaultTableModel modeldescription = new DefaultTableModel();
        JTable descriptiontable = new JTable(modeldescription);
        DefaultTableModel modelroom = new DefaultTableModel();
        modelroom.addColumn("nazwa_pokoju");
        modelroom.addColumn("Cena");
        modelroom.addColumn("Liczba wolnych pokoi");
        JTable roomtable = new JTable(modelroom);
        JLabel hoteldescriptionlabel = new JLabel("Opinie o hotelu");
        JScrollPane paneldescription = new JScrollPane(descriptiontable);
        DefaultTableModel modelreservation = new DefaultTableModel();
        modelreservation.addColumn("Hotel");
        modelreservation.addColumn("Nazwa_pokoju");
        modelreservation.addColumn("Data poczatku rezerwacji");
        modelreservation.addColumn("Data końca rezerwacji");
        modelreservation.addColumn("Imię");
        modelreservation.addColumn("Nazwisko");
        JTable reservationtable = new JTable(modelreservation);
        JScrollPane panelreservation = new JScrollPane(reservationtable);
        JButton acceptreservation = new JButton("Zaakceptuj rezerwacje w podanym terminie");
        columnvector.add("Nazwa hotelu");
        columnvector.add("średnia cena pokoi");
        columnvector.add("Liczba wolnych pokoi");
        columnvector.add("Liczba_gwiazdek");
        JTable allhoteltable = new JTable(new DefaultTableModel(doublevector,columnvector));
        JTable allhoteltableowner = new JTable(new DefaultTableModel(doublevector,columnvector));
        JLabel hotelnamelabel = new JLabel("Nazwa hotelu");
        JTextField hotelnametext = new JTextField();
        JLabel averagepricelabel = new JLabel("średnia cena pokoju");
        JTextField averagepricetext = new JTextField();
        JLabel numberroomslabel = new JLabel("Liczba wolnych pokoi");
        JTextField numberroomstext = new JTextField();
        JLabel starslabel = new JLabel("Liczba gwiazdek");
        JTextField starstext = new JTextField();
        JLabel hotelcitylabel = new JLabel("miasto");
        JTextField hotelcitytext = new JTextField();
        JButton accepthotel = new JButton("Dodaj hotel");
        gbc.weightx = 2.0;
        gbc.weighty = 2.0;
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.insets = new Insets(20,3,3,3);
        comboBoxPane.add(maintitle,gbc);
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.insets = new Insets(3,3,3,3);
        comboBoxPane.add(citytitle,gbc);
        gbc.gridx = 4;
        gbc.gridy = 3;
        comboBoxPane.add(citytext,gbc);
        gbc.gridx = 4;
        gbc.gridy = 4;
        comboBoxPane.add(acceptcity,gbc);
        gbc.gridx = 7;
        gbc.gridy = 2;
        comboBoxPane.add(user,gbc);
        gbc.gridx = 7;
        gbc.gridy = 3;
        comboBoxPane.add(hoteluser,gbc);
        JPanel card1 = new JPanel();
        allhoteltable.setSelectionModel(new ForcedListSelectionModel());
        allhoteltableowner.setSelectionModel(new ForcedListSelectionModel());
        Dimension d = allhoteltable.getPreferredSize();
        Dimension downer = allhoteltableowner.getPreferredSize();
        JScrollPane js = new JScrollPane(allhoteltable);
        JScrollPane jsroom = new JScrollPane(roomtable);
        DefaultTableModel modeldesc = (DefaultTableModel) descriptiontable.getModel();
        modeldesc.addColumn("Opinie");
        JScrollPane jsowner = new JScrollPane(allhoteltableowner);
        card1.add(js);
        JButton movetohotel = new JButton("Przejdź");
        JPanel freepanel1 = new JPanel(new BorderLayout());
        JPanel freepanel2 = new JPanel(new BorderLayout());
        JPanel freepanel3 = new JPanel(new BorderLayout());
        JPanel card3 = new JPanel(new GridBagLayout());
        JPanel card4 = new JPanel(new GridBagLayout());
        JPanel card5 = new JPanel(new GridBagLayout());
        JPanel card6 = new JPanel(new GridBagLayout());
        JPanel card7 = new JPanel(new GridBagLayout());
        JPanel card8 = new JPanel(new GridBagLayout());
        JPanel card9 = new JPanel(new GridBagLayout());
        JPanel card10 = new JPanel(new GridBagLayout());
        card3.add(jsroom);
        card3.add(gotoreservationdata);
        card3.add(gobacktocard11);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 13;
        card4.add(freepanel1,gbc);
        gbc.gridx = 1;
        gbc.gridy = 15;
        card4.add(freepanel2,gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        card4.add(namelabel,gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        nametext.setMaximumSize(new Dimension(100, 20));
        card4.add(nametext,gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        card4.add(lastnamelabel,gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        card4.add(lastnametext,gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        card4.add(datestartlabel,gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
        card4.add(datestart,gbc);
        gbc.gridx = 1;
        gbc.gridy = 7;
        card4.add(dateendlabel,gbc);
        gbc.gridx = 1;
        gbc.gridy = 8;
        card4.add(dateend,gbc);
        gbc.gridx = 1;
        gbc.gridy = 9;
        card4.add(acceptreservation,gbc);
        gbc.gridx = 1;
        gbc.gridy = 10;
        card4.add(gobacktocard11,gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        card5.add(ownerlabel,gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        card5.add(jsowner,gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        card5.add(addrooms,gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        card5.add(addhotel,gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        card5.add(displayreservation,gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        card6.add(roomnamelabel,gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        card6.add(roomnametext,gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        card6.add(roomnpricelabel,gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        card6.add(roompricetext,gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        card6.add(roomnumberlabel,gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
        card6.add(roomnumbertext,gbc);
        gbc.gridx = 1;
        gbc.gridy = 7;
        card6.add(addroomtodatabase,gbc);
        gbc.gridx = 1;
        gbc.gridy = 8;
        card6.add(backtoownertable,gbc);
        gbc.gridx = 1;
        gbc.gridy = 9;
        JPanel freepanel = new JPanel(new BorderLayout());
        gbc.gridx = 1;
        gbc.gridy =13;
        card6.add(freepanel,gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        card7.add(freepanel2,gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 40;
        gbc.gridx = 4;
        gbc.gridy = 1;
        card7.add(adddescriptionlabel,gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 10;
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        card7.add(adddescription,gbc);
        gbc.ipady = 5;
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        card7.add(acceptdescription,gbc);
        gbc.gridx = 6;
        gbc.gridy = 3;
        card7.add(gobacktocard13,gbc);
        gbc.gridx = 6;
        gbc.gridy = 3;
        card7.add(freepanel,gbc);
        gbc.gridx = 5;
        gbc.gridy = 3;
        card7.add(freepanel1,gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        card8.add(paneldescription,gbc);
        gbc.gridx = 2;
        gbc.gridy = 2;
        card8.add(gobacktocard1,gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        card9.add(hotelnamelabel,gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        card9.add(hotelnametext,gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        card9.add(averagepricelabel,gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        card9.add(averagepricetext,gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        card9.add(numberroomslabel,gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
        card9.add(numberroomstext,gbc);
        gbc.gridx = 1;
        gbc.gridy = 7;
        card9.add(starslabel,gbc);
        gbc.gridx = 1;
        gbc.gridy = 8;
        card9.add(starstext,gbc);
        gbc.gridx = 1;
        gbc.gridy = 9;
        card9.add(hotelcitylabel,gbc);
        gbc.gridx = 1;
        gbc.gridy = 10;
        card9.add(hotelcitytext,gbc);
        gbc.gridx = 1;
        gbc.gridy = 11;
        card9.add(accepthotel,gbc);
        gbc.gridx = 1;
        gbc.gridy =1;
        card10.add(panelreservation,gbc);
        gbc.gridx = 1;
        gbc.gridy =2;
        card10.add(gobacktocard14,gbc);
        card6.add(freepanel,gbc);
        gbc.gridx = 2;
        gbc.gridy = 1;
        card7.add(freepanel2,gbc);
        String queryroom = "SELECT * FROM Pokoje WHERE Hotel LIKE 'Hotel Huzar'";
        ResultSet rs_room = stmt.executeQuery(queryroom);
        Vector<Vector<String>> roomvector = new Vector<Vector<String>>();
        while(rs_room.next()){
            Vector<String> singlevector = new Vector<String>();
            singlevector.add(rs_room.getString("nazwa_pokoju"));
            singlevector.add(rs_room.getString("Cena"));
            singlevector.add(rs_room.getString("liczba wolnych pokoi"));
            roomvector.add(singlevector);
            System.out.println(roomvector);
        }
        acceptdescription.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String hotel = (String) allhoteltable.getValueAt(allhoteltable.getSelectedRow(), 0);
                    if(adddescription.getText() != ""){
                    PreparedStatement statement =con.prepareStatement("INSERT INTO Opinie VALUES (?,?)");
                    statement.setString(1,hotel);
                    statement.setString(2,adddescription.getText());
                    statement.execute();
                    showMessageDialog(null,"Recenzja została wysłana");
                    }else{
                        showMessageDialog(null,"Wprowadź recenzję");
                    }
                }catch(Exception e2){
                    showMessageDialog(null,"Recenzja nie została wysłana popraw dane");
                }
            }
        });
        movetohotel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    DefaultTableModel model = (DefaultTableModel) roomtable.getModel();
                    String hotel = (String) allhoteltable.getValueAt(allhoteltable.getSelectedRow(), 0);
                    PreparedStatement statement = con.prepareStatement("SELECT * from Pokoje WHERE  Hotel Like ?");
                    statement.setString(1,hotel);
                    ResultSet roomresult  = statement.executeQuery();
                    Vector<Vector<String>> roomvector = new Vector<Vector<String>>();
                    if (model.getRowCount() > 0) {
                        for (int i = model.getRowCount() - 1; i > -1; i--) {
                            model.removeRow(i);
                        }
                    }
                    while(roomresult.next()){
                        Vector<String> singlevector = new Vector<String>();
                        singlevector.add(roomresult.getString("nazwa_pokoju"));
                        singlevector.add(roomresult.getString("Cena"));
                        singlevector.add(roomresult.getString("Liczba wolnych pokoi"));
                        roomvector.add(singlevector);
                        model.addRow(singlevector);
                    }
                    Vector<String> roomcolumnvector = new Vector<String>();
                    roomcolumnvector.add("Nazwa pokoju");
                    roomcolumnvector.add("Cena za dzień");
                    roomcolumnvector.add("Liczba wolnych pokoi");
                    CardLayout cardLayout=(CardLayout) cards.getLayout();
                    cardLayout.show(cards,"pokoje");
                }
                catch(ArrayIndexOutOfBoundsException | SQLException r){
                    String hotel = null;
                    System.out.println(hotel);
                }}
        });
        // Listeners
        addhoteldescription.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    CardLayout cardLayout=(CardLayout) cards.getLayout();
                    cardLayout.show(cards,"dodaj opinie");
                }catch(Exception e2){
                    System.out.println("Nie można dodać opinii");
                }
            }
        });
        displayhoteldescription.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    paneldescription.setPreferredSize(new Dimension(downer.width,descriptiontable.getRowHeight()*10));
                    paneldescription.setVisible(true);
                    CardLayout cardLayout=(CardLayout) cards.getLayout();
                    cardLayout.show(cards,"wyswietl opinie");
                    DefaultTableModel modeldesc = (DefaultTableModel) descriptiontable.getModel();
//                    modeldesc.addColumn("Opinie");
                    if (modeldesc.getRowCount() > 0) {
                        for (int i = modeldesc.getRowCount() - 1; i > -1; i--) {
                            modeldesc.removeRow(i);
                        }
                    }
                    PreparedStatement statement =con.prepareStatement("SELECT * from Opinie WHERE Hotel Like ?");
                    statement.setString(1,"Hotel Huzar");
                    ResultSet descriptionresult  = statement.executeQuery();
                    while(descriptionresult.next()){
                        System.out.println(descriptionresult.getString("opinia"));
                        Vector<String> singlevector = new Vector<String>();
                        singlevector.add(descriptionresult.getString("opinia"));
                        System.out.println(singlevector);
                        modeldesc.addRow(singlevector);
                        System.out.println("dodanie ");
                    }
                    System.out.println(modeldesc.getColumnCount());
                }catch(Exception e3){
                    System.out.println("Nie można wyświetlić opinii");
                }
            }
        });
        acceptcity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PreparedStatement statement =con.prepareStatement("SELECT * from Hotel WHERE  miasto Like ?");
                    statement.setString(1,citytext.getText());
                    ResultSet roomresult  = statement.executeQuery();
                    DefaultTableModel model = (DefaultTableModel) allhoteltable.getModel();
                    DefaultTableModel model2 = (DefaultTableModel) allhoteltableowner.getModel();
                    if (model.getRowCount() > 0) {
                        for (int i = model.getRowCount() - 1; i > -1; i--) {
                            model.removeRow(i);
                        }
                    }
                    if (model2.getRowCount() > 0) {
                        for (int i = model2.getRowCount() - 1; i > -1; i--) {
                            model2.removeRow(i);
                        }
                    }
                    while (roomresult.next()) {
                        System.out.println(roomresult.getString("nazwa"));
                        Vector<String> singlevector = new Vector<String>();
                        singlevector.add(roomresult.getString("nazwa"));
                        singlevector.add(roomresult.getString("srednia_cena_pokoju"));
                        singlevector.add(roomresult.getString("liczba_wolnych_pokoi"));
                        singlevector.add(roomresult.getString("liczba_gwiazdek"));
                        model.addRow(singlevector);

                        roomvector.add(singlevector);
                        System.out.println(roomvector);
                    }
//                model.addRow(new Object[]{"Column 1", "Column 2", "Column 3"});
                }catch(Exception event){
                    System.out.println("Coś nie działa");
                }
            }

        });
        gobacktocard1.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e){
               try{
                   PreparedStatement statement =con.prepareStatement("SELECT * from Hotel ");
                   DefaultTableModel model = (DefaultTableModel) allhoteltable.getModel();
                   ResultSet hotelresult  = statement.executeQuery();
                   if (model.getRowCount() > 0) {
                       for (int i = model.getRowCount() - 1; i > -1; i--) {
                           model.removeRow(i);
                       }
                   }
                   while(hotelresult.next()){
                       Vector<String> singlevector = new Vector<String>();
                       singlevector.add(hotelresult.getString("nazwa"));
                       singlevector.add(hotelresult.getString("srednia_cena_pokoju"));
                       singlevector.add(hotelresult.getString("liczba_wolnych_pokoi"));
                       singlevector.add(hotelresult.getString("liczba_gwiazdek"));
                       System.out.println(singlevector);
                       model.addRow(singlevector);
                       System.out.println("dodanie ");
                   }
                   CardLayout cardLayout=(CardLayout) cards.getLayout();
                   cardLayout.show(cards,BUTTONPANEL);
               }catch(Exception et){
                   System.out.println("Nie można wrócić");
               }
           }
        });
        gobacktocard11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    PreparedStatement statement =con.prepareStatement("SELECT * from Hotel ");
                    DefaultTableModel model = (DefaultTableModel) allhoteltable.getModel();
                    ResultSet hotelresult  = statement.executeQuery();
                    if (model.getRowCount() > 0) {
                        for (int i = model.getRowCount() - 1; i > -1; i--) {
                            model.removeRow(i);
                        }
                    }
                    while(hotelresult.next()){
                        Vector<String> singlevector = new Vector<String>();
                        singlevector.add(hotelresult.getString("nazwa"));
                        singlevector.add(hotelresult.getString("srednia_cena_pokoju"));
                        singlevector.add(hotelresult.getString("liczba_wolnych_pokoi"));
                        singlevector.add(hotelresult.getString("liczba_gwiazdek"));
                        System.out.println(singlevector);
                        model.addRow(singlevector);
                        System.out.println("dodanie ");
                    }
                    CardLayout cardLayout=(CardLayout) cards.getLayout();
                    cardLayout.show(cards,BUTTONPANEL);
                }catch(Exception et){
                    System.out.println("Nie można wrócić");
                }
            }
        });
        gobacktocard12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    PreparedStatement statement =con.prepareStatement("SELECT * from Hotel ");
                    DefaultTableModel model = (DefaultTableModel) allhoteltable.getModel();
                    ResultSet hotelresult  = statement.executeQuery();
                    if (model.getRowCount() > 0) {
                        for (int i = model.getRowCount() - 1; i > -1; i--) {
                            model.removeRow(i);
                        }
                    }
                    while(hotelresult.next()){
                        Vector<String> singlevector = new Vector<String>();
                        singlevector.add(hotelresult.getString("nazwa"));
                        singlevector.add(hotelresult.getString("srednia_cena_pokoju"));
                        singlevector.add(hotelresult.getString("liczba_wolnych_pokoi"));
                        singlevector.add(hotelresult.getString("liczba_gwiazdek"));
                        System.out.println(singlevector);
                        model.addRow(singlevector);
                        System.out.println("dodanie ");
                    }
                    CardLayout cardLayout=(CardLayout) cards.getLayout();
                    cardLayout.show(cards,BUTTONPANEL);
                }catch(Exception et){
                    System.out.println("Nie można wrócić");
                }
            }
        });
        gobacktocard13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    PreparedStatement statement =con.prepareStatement("SELECT * from Hotel ");
                    DefaultTableModel model = (DefaultTableModel) allhoteltable.getModel();
                    ResultSet hotelresult  = statement.executeQuery();
                    if (model.getRowCount() > 0) {
                        for (int i = model.getRowCount() - 1; i > -1; i--) {
                            model.removeRow(i);
                        }
                    }
                    while(hotelresult.next()){
                        Vector<String> singlevector = new Vector<String>();
                        singlevector.add(hotelresult.getString("nazwa"));
                        singlevector.add(hotelresult.getString("srednia_cena_pokoju"));
                        singlevector.add(hotelresult.getString("liczba_wolnych_pokoi"));
                        singlevector.add(hotelresult.getString("liczba_gwiazdek"));
                        System.out.println(singlevector);
                        model.addRow(singlevector);
                        System.out.println("dodanie ");
                    }
                    CardLayout cardLayout=(CardLayout) cards.getLayout();
                    cardLayout.show(cards,BUTTONPANEL);
                }catch(Exception et){
                    System.out.println("Nie można wrócić");
                }
            }
        });
        gobacktocard14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    PreparedStatement statement =con.prepareStatement("SELECT * from Hotel ");
                    DefaultTableModel model = (DefaultTableModel) allhoteltable.getModel();
                    ResultSet hotelresult  = statement.executeQuery();
                    if (model.getRowCount() > 0) {
                        for (int i = model.getRowCount() - 1; i > -1; i--) {
                            model.removeRow(i);
                        }
                    }
                    while(hotelresult.next()){
                        Vector<String> singlevector = new Vector<String>();
                        singlevector.add(hotelresult.getString("nazwa"));
                        singlevector.add(hotelresult.getString("srednia_cena_pokoju"));
                        singlevector.add(hotelresult.getString("liczba_wolnych_pokoi"));
                        singlevector.add(hotelresult.getString("liczba_gwiazdek"));
                        System.out.println(singlevector);
                        model.addRow(singlevector);
                        System.out.println("dodanie ");
                    }
                    CardLayout cardLayout=(CardLayout) cards.getLayout();
                    cardLayout.show(cards,BUTTONPANEL);
                }catch(Exception et){
                    System.out.println("Nie można wrócić");
                }
            }
        });
        displayreservation.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                String hotel = (String) allhoteltable.getValueAt(allhoteltableowner.getSelectedRow(), 0);
                System.out.println(hotel);

                try{
                    PreparedStatement statement =con.prepareStatement("SELECT * from Rezerwacje WHERE  Hotel Like ?");
                    statement.setString(1,hotel);
                    ResultSet hotelresult  = statement.executeQuery();
                    DefaultTableModel model = (DefaultTableModel) reservationtable.getModel();
                    if (model.getRowCount() > 0) {
                        for (int i = model.getRowCount() - 1; i > -1; i--) {
                            model.removeRow(i);
                        }
                    }
                    while(hotelresult.next()){
                        Vector<String> singlevector = new Vector<String>();
                        singlevector.add(hotelresult.getString("Hotel"));
                        singlevector.add(hotelresult.getString("nazwa_pokoju"));
                        singlevector.add(hotelresult.getString("Data poczatku rezerwacji"));
                        singlevector.add(hotelresult.getString("Data konca rezerwacji"));
                        singlevector.add(hotelresult.getString("Imie"));
                        singlevector.add(hotelresult.getString("Nazwisko"));
                        System.out.println(singlevector);
                        model.addRow(singlevector);

                    }
                    CardLayout cardLayout=(CardLayout) cards.getLayout();
                    cardLayout.show(cards,BUTTONPANEL);
                }catch(Exception et){
                    System.out.println("Nie można wrócić");
                }
                CardLayout cardLayout=(CardLayout) cards.getLayout();
                cardLayout.show(cards,"wyswietl rezerwacje");
            }
        });
        accepthotel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                try{
                    if(hotelnametext.getText().equals("")) {
                        showMessageDialog(null, "Podaj nazwe hotelu");
                    }else if(averagepricetext.getText().equals("")){
                        showMessageDialog(null, "Podaj srednia cene pokoju");
                    }
                    else if(numberroomstext.getText().equals("")){
                        showMessageDialog(null, "Podaj aktualną liczbę pokoi ");
                    }
                    else if(starstext.getText().equals("")){
                        showMessageDialog(null, "Podaj liczbę gwiazdek");
                    }
                    else if(hotelcitytext.getText().equals("")){
                        showMessageDialog(null, "Podaj nazwę miasta");
                    }
                    else{
                        PreparedStatement statement =con.prepareStatement("INSERT INTO Hotel (nazwa,srednia_cena_pokoju,liczba_wolnych_pokoi,liczba_gwiazdek,miasto) VALUES (?,?,?,?,?)");
                        statement.setString(1,hotelnametext.getText());
                        statement.setInt(2,Integer.parseInt(averagepricetext.getText()));
                        statement.setInt(3,Integer.parseInt(numberroomstext.getText()));
                        statement.setInt(4,Integer.parseInt(starstext.getText()));
                        statement.setString(5,hotelcitytext.getText());
                        statement.execute();
                        showMessageDialog(null,"Twój hotel  został zarejestrowany w bazie danych");
                    }
                }catch(Exception e){
                    System.out.println(e);
                    showMessageDialog(null,"Wystąpił błąd");
                }

            }
        });

        acceptreservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{

                    if(nametext.getText().equals("")) {
                        showMessageDialog(null, "Podaj imię");
                    }else if(lastnametext.getText().equals("")){
                        showMessageDialog(null, "Podaj Nazwisko");
                    }
                    else if(datestart.getText().equals("")){
                        showMessageDialog(null, "Podaj Date rozpoczęcia");
                    }
                    else if(dateend.getText().equals("")){
                        showMessageDialog(null, "Podaj Date zakończenia rezerwacji");
                    }
                    else{
                        PreparedStatement statement =con.prepareStatement("INSERT INTO Rezerwacje VALUES (?,?,?,?,?,?)");
                        statement.setString(1,"Hotel Huzar");
                        statement.setString(2,"apartament prezydencki");
                        statement.setString(3,datestart.getText());
                        statement.setString(4,dateend.getText());
                        statement.setString(5,nametext.getText());
                        statement.setString(6,lastnametext.getText());
                        statement.execute();
                        showMessageDialog(null,"Twoja rezerwacja została zarejestrowana");
                    }
                }catch(Exception e1){
                    showMessageDialog(null,"Wystąpił błąd. Twoja rezerwacja nie została zarejestrowana");
                }
            }
        });


        displayhoteldescription.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    DefaultTableModel model = (DefaultTableModel) allhoteltable.getModel();
                    if (model.getRowCount() > 0) {
                        for (int i = model.getRowCount() - 1; i > -1; i--) {
                            model.removeRow(i);
                        }
                    }
                    CardLayout cardLayout=(CardLayout) cards.getLayout();
                    cardLayout.show(cards,"wyświetl opinie");
                }catch(Exception el){
                    System.out.println("Błąd wyświetlenia komentarzy");
                }
            }
        });

        addrooms.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String hotel = (String) allhoteltable.getValueAt(allhoteltableowner.getSelectedRow(), 0);
                System.out.println(hotel);
                CardLayout cardLayout=(CardLayout) cards.getLayout();
                cardLayout.show(cards,"dodaj pokoje");
            }
        });
        addhotel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                CardLayout cardLayout=(CardLayout) cards.getLayout();
                cardLayout.show(cards,"dodaj hotel");
            }
        });
        gotoreservationdata.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println("Przejdz do karty 4 rezerwacji");
                    CardLayout cardLayout=(CardLayout) cards.getLayout();
                    cardLayout.show(cards,"rezerwacja");
//                model.addRow(new Object[]{"Column 1", "Column 2", "Column 3"});
                }catch(Exception event){
                    System.out.println("Coś nie działa");
                }
            }
        });
        hoteluser.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    PreparedStatement statement =con.prepareStatement("SELECT * from Hotel ");
                    DefaultTableModel model = (DefaultTableModel) allhoteltable.getModel();
                    ResultSet hotelresult  = statement.executeQuery();
                    if (model.getRowCount() > 0) {
                        for (int i = model.getRowCount() - 1; i > -1; i--) {
                            model.removeRow(i);
                        }
                    }
                    while(hotelresult.next()){
                        Vector<String> singlevector = new Vector<String>();
                        singlevector.add(hotelresult.getString("nazwa"));
                        singlevector.add(hotelresult.getString("srednia_cena_pokoju"));
                        singlevector.add(hotelresult.getString("liczba_wolnych_pokoi"));
                        singlevector.add(hotelresult.getString("liczba_gwiazdek"));
                        System.out.println(singlevector);
                        model.addRow(singlevector);
                        System.out.println("dodanie ");
                    }
                    CardLayout cardLayout=(CardLayout) cards.getLayout();
                    cardLayout.show(cards,"wlascicielmain");
                    user.setEnabled(true);
                    hoteluser.setEnabled(false);
                }catch(Exception ex){
                    System.out.println("przejscie na wlasciciel main");
                }
            }
        });
        user.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    PreparedStatement statement =con.prepareStatement("SELECT * from Hotel ");
                    DefaultTableModel model = (DefaultTableModel) allhoteltable.getModel();
                    ResultSet hotelresult  = statement.executeQuery();
                    if (model.getRowCount() > 0) {
                        for (int i = model.getRowCount() - 1; i > -1; i--) {
                            model.removeRow(i);
                        }
                    }
                    while(hotelresult.next()){
                        Vector<String> singlevector = new Vector<String>();
                        singlevector.add(hotelresult.getString("nazwa"));
                        singlevector.add(hotelresult.getString("srednia_cena_pokoju"));
                        singlevector.add(hotelresult.getString("liczba_wolnych_pokoi"));
                        singlevector.add(hotelresult.getString("liczba_gwiazdek"));
                        System.out.println(singlevector);
                        model.addRow(singlevector);
                        System.out.println("dodanie ");
                    }

                    CardLayout cardLayout=(CardLayout) cards.getLayout();
                    cardLayout.show(cards,BUTTONPANEL);
                    user.setEnabled(false);
                    hoteluser.setEnabled(true);

                }catch(Exception ex){
                    System.out.println("przejscie na user main");
                }
            }
        });
        backtoownertable.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                CardLayout cardLayout=(CardLayout) cards.getLayout();
                cardLayout.show(cards,"wlascicielmain");
            }
        });

        addroomtodatabase.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String hotel = (String) allhoteltable.getValueAt(allhoteltableowner.getSelectedRow(), 0);
                    System.out.println(hotel);
                    PreparedStatement statement =con.prepareStatement("INSERT INTO Pokoje VALUES (?,?,?,?)");
                    statement.setString(1,hotel);
                    statement.setString(2,roomnametext.getText());
                    statement.setInt(3,Integer.parseInt(roompricetext.getText()));
                    statement.setInt(4,Integer.parseInt(roomnumbertext.getText()));
                    statement.execute();
                    showMessageDialog(null, "Pokój został dodany do bazydanych");
                }catch(Exception ex){
                    System.out.println("przejscie na user main");
                }
            }
        });
        card1.add(js);
        card1.add(movetohotel);
        card1.add(addhoteldescription);
        card1.add(displayhoteldescription);
        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextField", 20));
        cards = new JPanel(new CardLayout());
        cards.add(card1, BUTTONPANEL);
        cards.add(card2, TEXTPANEL);
        cards.add(card3,"pokoje");
        cards.add(card4,"rezerwacja");
        cards.add(card5,"wlascicielmain");
        cards.add(card6,"dodaj pokoje");
        cards.add(card7,"dodaj opinie");
        cards.add(card8,"wyświetl opinie");
        cards.add(card9,"dodaj hotel");
        cards.add(card10,"wyswietl rezerwacje");
        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
    private static void createAndShowGUI() throws SQLException {
        JFrame frame = new JFrame("Sytem rezerwacji hoteli");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CardLayoutDemo demo = new CardLayoutDemo();
        demo.addComponentToPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) throws SQLException {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    createAndShowGUI();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }}
        });
//        con.close();
    }
}