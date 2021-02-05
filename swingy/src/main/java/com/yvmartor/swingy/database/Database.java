package com.yvmartor.swingy.database;

import com.yvmartor.swingy.models.artefacts.*;
import com.yvmartor.swingy.models.hero.*;
import com.yvmartor.swingy.models.scenario.ConsoleStringColor;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    private static final String url = "jdbc:sqlite:sqlite/swingy.db";

    public static void createNewDatabase(String fileName) {

        String url = "jdbc:sqlite:sqlite/" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
            }

        } catch (SQLException e) {
            ConsoleStringColor.error("An error occured, impossible to create the Database.");
        }
    }

    public static void createNewTable() {

        // SQL statement for creating a new table
        String hero = "CREATE TABLE IF NOT EXISTS heroes (\n"
                + "	id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "	name TEXT NOT NULL,\n"
                + "	class TEXT NOT NULL,\n"
                + "	xp REAL NOT NULL,\n"
                + "	level INTEGER NOT NULL,\n"
                + "	attack INTEGER NOT NULL,\n"
                + "	defense INTEGER NOT NULL,\n"
                + "	hp INTEGER NOT NULL"
                + ");";

        String weapon = "CREATE TABLE IF NOT EXISTS weapons (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	name TEXT NOT NULL,\n"
                + " points INTEGER NOT NULL,\n"
                + " owner INTEGER NOT NULL,\n"
                + "FOREIGN KEY (owner) REFERENCES hero (id) ON DELETE CASCADE"
                + ");";

        String armor = "CREATE TABLE IF NOT EXISTS armors (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	name TEXT NOT NULL,\n"
                + " points INTEGER NOT NULL,\n"
                + " owner INTEGER NOT NULL,\n"
                + "FOREIGN KEY (owner) REFERENCES hero (id) ON DELETE CASCADE"
                + ");";

        String helm = "CREATE TABLE IF NOT EXISTS helms (\n"
                + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
                + "	name TEXT NOT NULL,\n"
                + " points INTEGER NOT NULL,\n"
                + " owner INTEGER NOT NULL,\n"
                + "FOREIGN KEY (owner) REFERENCES hero (id) ON DELETE CASCADE"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(hero);
            stmt.execute(weapon);
            stmt.execute(armor);
            stmt.execute(helm);
        } catch (SQLException e) {
            ConsoleStringColor.error("An error occured impossible to create database tables.");
        }
    }

    public static int createHero(Hero hero) throws SQLException {
        String query = "INSERT INTO heroes ("
                + " id,"
                + " name,"
                + " class,"
                + " xp,"
                + " level,"
                + " attack,"
                + " defense,"
                + " hp ) VALUES ("
                + "null, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);){
            // set all the preparedstatement parameters
            st.setString(1, hero.getName());
            st.setString(2, hero.getHeroClass());
            st.setDouble(3, hero.getXp());
            st.setInt(4, hero.getLevel());
            st.setInt(5, hero.getAttak());
            st.setInt(6, hero.getDefense());
            st.setInt(7, hero.getHitPoints());

            // execute the preparedstatement insert
            int affected_rows = st.executeUpdate();
            if (affected_rows == 0){
                throw new SQLException("Creating user failed, no rows affected");
            }
            try (ResultSet generatedKeys = st.getGeneratedKeys()){
                if (generatedKeys.next()){
                    addWeapon(hero.getWeapon(), generatedKeys.getInt(1));
                    addArmor(hero.getArmor(), generatedKeys.getInt(1));
                    addHelm(hero.getHelm(), generatedKeys.getInt(1));
                }
                return generatedKeys.getInt(1);
            }
        }
        catch (SQLException se)
        {
            // log exception
            throw se;
        }
    }

    private static void addWeapon(Weapon weapon, int id) throws SQLException{
        String query = "INSERT INTO weapons ("
                + " id,"
                + " name,"
                + " points,"
                + " owner ) VALUES ("
                + "null, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);){

            // set all the preparedstatement parameters
            st.setString(1, weapon.getName());
            st.setInt(2, weapon.getPoints());
            st.setInt(3, id);

            // execute the preparedstatement insert
            st.executeUpdate();

        }
        catch (SQLException se)
        {
            // log exception
            throw se;
        }
    };

    private static void addArmor(Armor armor, int id) throws SQLException{
        String query = "INSERT INTO armors ("
                + " id,"
                + " name,"
                + " points,"
                + " owner ) VALUES ("
                + "null, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);){

            // set all the preparedstatement parameters
            st.setString(1, armor.getName());
            st.setInt(2, armor.getPoints());
            st.setInt(3, id);

            // execute the preparedstatement insert
            st.executeUpdate();

        }
        catch (SQLException se)
        {
            // log exception
            throw se;
        }
    };

    private static void addHelm(Helm helm, int id) throws SQLException{
        String query = "INSERT INTO helms ("
                + " id,"
                + " name,"
                + " points,"
                + " owner ) VALUES ("
                + "null, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);){

            // set all the preparedstatement parameters
            st.setString(1, helm.getName());
            st.setInt(2, helm.getPoints());
            st.setInt(3, id);

            // execute the preparedstatement insert
            st.executeUpdate();

        }
        catch (SQLException se)
        {
            // log exception
            throw se;
        }
    };

    public static void updateHero(Hero hero) throws SQLException{
        String query = "UPDATE heroes SET name = ?, " +
                "class = ?, " +
                "xp = ?, " +
                "level = ?, " +
                "attack = ?, " +
                "defense = ?, " +
                "hp = ? " +
                "WHERE id = ? ";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);){

            // set the preparedstatement parameters
            ps.setString(1, hero.getName());
            ps.setString(2, hero.getHeroClass());
            ps.setDouble(3, hero.getXp());
            ps.setInt(4, hero.getLevel());
            ps.setInt(5, hero.getAttak());
            ps.setInt(6, hero.getDefense());
            ps.setInt(7, hero.getHitPoints());
            ps.setInt(8, hero.getIdx());


            // call executeUpdate to execute our sql update statement
            ps.executeUpdate();
            updateWeapon(hero.getWeapon(), hero.getIdx());
            updateArmor(hero.getArmor(), hero.getIdx());
            updateHelm(hero.getHelm(), hero.getIdx());
        }
        catch (SQLException se)
        {
            // log the exception
            throw se;
        }
    }

    private static void updateWeapon(Weapon weapon, int id) throws SQLException{
        String query = "UPDATE weapons SET "
                + " name = ?,"
                + " points = ?"
                + " WHERE owner = ? ";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);){

            // set all the preparedstatement parameters
            st.setString(1, weapon.getName());
            st.setInt(2, weapon.getPoints());
            st.setInt(3, id);

            // execute the preparedstatement insert
            st.executeUpdate();

        }
        catch (SQLException se)
        {
            // log exception
            throw se;
        }
    };

    private static void updateArmor(Armor armor, int id) throws SQLException{
        String query = "UPDATE armors SET "
                + " name = ?,"
                + " points = ?"
                + " WHERE owner = ? ";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);){

            // set all the preparedstatement parameters
            st.setString(1, armor.getName());
            st.setInt(2, armor.getPoints());
            st.setInt(3, id);

            // execute the preparedstatement insert
            st.executeUpdate();

        }
        catch (SQLException se)
        {
            // log exception
            throw se;
        }
    };

    private static void updateHelm(Helm helm, int id) throws SQLException{
        String query = "UPDATE helms SET "
                + " name =?,"
                + " points = ?"
                + " WHERE owner = ? ";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);){

            // set all the preparedstatement parameters
            st.setString(1, helm.getName());
            st.setInt(2, helm.getPoints());
            st.setInt(3, id);

            // execute the preparedstatement insert
            st.executeUpdate();

        }
        catch (SQLException se)
        {
            // log exception
            throw se;
        }
    };

    public static ArrayList<Hero> getAllHeroes() throws SQLException{
        ArrayList<Hero> heroArrayList = new ArrayList<Hero>();

        HashMap<String, HeroBuilder> builder_tab = new HashMap<String, HeroBuilder>();
        builder_tab.put("Chicken", new ChickenHeroBuilder());
        builder_tab.put("Black Knight", new BlackKnightBuilder());
        builder_tab.put("Dog Handler", new DogHandlerBuilder());
        builder_tab.put("Mad Knight", new MadKnightBuilder());
        builder_tab.put("Magician", new MagicianBuilder());
        builder_tab.put("Saboteur", new SaboteurBuilder());
        builder_tab.put("Witch", new WitchBuilder());

        String query = "SELECT * FROM heroes";

        try (Connection conn = DriverManager.getConnection(url);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query);){

            while (rs.next()){
                HeroDirector director = new HeroDirector();
                HeroBuilder builder = builder_tab.get(rs.getString("class"));
                director.setHeroBuilder(builder);
                director.constructHero();
                Hero hero = director.getHero();
                hero.setIdx(rs.getInt("id"));
                hero.setXp(rs.getDouble("xp"));
                hero.setLevel(rs.getInt("level"));
                hero.setAttak(rs.getInt("attack"));
                hero.setDefense(rs.getInt("defense"));
                hero.setHitPoints(rs.getInt("hp"));
                hero.setWeapon(getWeapon(hero.getIdx()));
                hero.setArmor(getArmor(hero.getIdx()));
                hero.setHelm(getHelm(hero.getIdx()));
                heroArrayList.add(hero);
            }
            return heroArrayList;
        }
        catch (SQLException se)
        {
            // log exception
            throw se;
        }
    }

    private static Weapon getWeapon(int id) throws SQLException{
        String query = "SELECT name, points FROM weapons WHERE owner = id";
        Weapon weapon = null;

        try (Connection conn = DriverManager.getConnection(url);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query);){

            while (rs.next()){
                weapon = new WeaponBuilder()
                        .name(rs.getString("name"))
                        .points(rs.getInt("points"))
                        .image()
                        .increasedStat()
                        .build();
            }
            return weapon;
        }
        catch (SQLException se)
        {
            // log exception
            throw se;
        }
    }

    private static Armor getArmor(int id) throws SQLException{
        String query = "SELECT name, points FROM armors WHERE owner = id";
        Armor armor = null;

        try (Connection conn = DriverManager.getConnection(url);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query);){

            while (rs.next()){
                armor = new ArmorBuilder()
                        .name(rs.getString("name"))
                        .points(rs.getInt("points"))
                        .image()
                        .increasedStat()
                        .build();
            }
            return armor;
        }
        catch (SQLException se)
        {
            // log exception
            throw se;
        }
    }

    private static Helm getHelm(int id) throws SQLException{
        String query = "SELECT name, points FROM helms WHERE owner = id";
        Helm helm = null;

        try (Connection conn = DriverManager.getConnection(url);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query);){

            while (rs.next()){
                helm = new HelmBuilder()
                        .name(rs.getString("name"))
                        .points(rs.getInt("points"))
                        .image()
                        .increasedStat()
                        .build();
            }
            return helm;
        }
        catch (SQLException se)
        {
            // log exception
            throw se;
        }
    }

}
