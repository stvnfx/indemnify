/*
 * === C.A. Scott Consulting Actuary ===
 *   ________     ____         __  __
 *  / ___/ _ |   / __/______  / /_/ /_
 * / /__/ __ |  _\ \/ __/ _ \/ __/ __/
 * \___/_/ |_| /___/\__/\___/\__/\__/
 *
 * Copyright (c) 2012. CA Scott
 */

package za.co.cascott.indemnity;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataCollection implements Serializable {
    private static Logger logger = Logger.getLogger(DataCollection.class.getName());

    private Map<String, Object> model = null;

    NumberFormat pformatter = new DecimalFormat("0.00%");
    NumberFormat dformatter = new DecimalFormat("###,###,###");
    NumberFormat zeroformatter = new DecimalFormat("#########");
    //NumberFormat dformatter = NumberFormat.getCurrencyInstance(new Locale("eng", "zaf"));

    SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd MMMMM yyyy");
    SimpleDateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy");

    public DataCollection() {
        this.fundName = "";
        c.clear();
        //c.set(1800, 6, 31); //31 July 1800

        this.effectiveDate = c.getTime();

        this.coverFrom = c.getTime();

        this.coverTo = c.getTime();

        this.retroDate = c.getTime();

        this.preservationFund = false;
        this.investmentChoice = true;

        this.partEmp = 0;
        this.noPortfolios = 0;
        this.indemnityLimit = 0;
        this.annPremium = 0;
        this.firstAmount = 0;
        this.claimsYN = true;
        this.highClaim = 0;
        this.aggClaim = 0;
        this.noMembers = 0;
        this.annCons = 0;
        this.valInvest = 0;

        this.noDeathBens = 0;
        this.Db1 = 0;
        this.Db2 = 0;
        this.Db3 = 0;
        this.Db4 = 0;
        this.Db5 = 0;
        this.Db6 = 0;
        this.Db7 = 0;
        this.Db8 = 0;
        this.Db9 = 0;
        this.Db10 = 0;

        this.noMbrShares = 0;
        this.Ms1 = 0;
        this.Ms2 = 0;
        this.Ms3 = 0;
        this.Ms4 = 0;
        this.Ms5 = 0;
        this.Ms6 = 0;
        this.Ms7 = 0;
        this.Ms8 = 0;
        this.Ms9 = 0;
        this.Ms10 = 0;
    }

    public String dformat(Double a) {
        String comma = dformatter.format(a).replace(",", " ");
        return comma.replace(".", " ");
    }

    public String dformat(Long a) {
        String comma = dformatter.format(a).replace(",", " ");
        return comma.replace(".", " ");
    }

    public NumberFormat getZformatter() {
        return zeroformatter;
    }

    public NumberFormat getDformatter() {
        return dformatter;
    }

    public static final double COMPLIANCE_MINIMAL = 3;
    public static final double COMPLIANCE_PARTIAL = 2;
    public static final double COMPLIANCE_FULL = 0;

    public static final double WEIGHTING_LIGHT = 1;
    public static final double WEIGHTING_MEDIUM = 2;
    public static final double WEIGHTING_HEAVY = 3;
    public static final double WEIGHTING_MAX = 297;

    public static final String[] complianceList = {"Minimal", "Partial", "Full"};
    public static final String[] weightingList = {"Light", "Medium", "Heavy"};

    public String dc = null;
    public String rw = null;

    // ///////////////////////
    // Input Fund Data
    // ///////////////////////
    // Page 1
    private String fundName;
    private Boolean preservationFund; // Yes or No
    private Date effectiveDate;
    private int partEmp;
    private Boolean investmentChoice;
    private int noPortfolios;
    // Existing cover
    private Date coverFrom;
    private Date coverTo;
    private Date retroDate;
    private long annPremium;
    private Boolean claimsYN;
    private long indemnityLimit;
    private long highClaim;
    private long firstAmount;
    private long aggClaim;
    // Page 2
    private int noMembers;
    private long annCons;
    private long valInvest;

    long averageDeathBens;
    long averageMemberShare;

    long topDeath1;
    long topShare1;

    long minCover;

    long rndMinCover;
    // Top 10 Death Benefit Sums Assured
    private int noDeathBens;
    private long Db1;
    private long Db2;
    private long Db3;
    private long Db4;
    private long Db5;
    private long Db6;
    private long Db7;
    private long Db8;
    private long Db9;
    private long Db10;
    // Top 10 Member Shares
    private int noMbrShares;
    private long Ms1;
    private long Ms2;
    private long Ms3;
    private long Ms4;
    private long Ms5;
    private long Ms6;
    private long Ms7;
    private long Ms8;
    private long Ms9;
    private long Ms10;

    private double tb1;
    private double tb2;
    private double tb3;
    private double tb4;
    private double tb5;
    private double tb6;
    private double tb7;
    private double tb8;
    private double tb9;
    private double tb10;
    private double tb11;
    private double tb12;
    private double tb13;
    private double tb14;
    private double tb15;
    private double tb16;
    private double tb17;
    private double tb18;
    private double tb19;
    private double tb20;
    private double tb21;
    private double tb22;
    private double tb23;
    private double tb24;
    private double tb25;
    private double tb26;
    private double tb27;
    private double tb28;
    private double tb29;
    private double tb30;
    private double tb31;
    //FIXME: Fix Variable Names.
    private double tb33;
    private double tb34;
    private double tb35;
    private double tb36;

    private String cb1;
    private double cb1v;
    private String cb2;
    private double cb2v;
    private String cb3;
    private double cb3v;
    private String cb4;
    private double cb4v;
    private String cb5;
    private double cb5v;
    private String cb6;
    private double cb6v;
    private String cb7;
    private double cb7v;
    private String cb8;
    private double cb8v;
    private String cb9;
    private double cb9v;
    private String cb10;
    private double cb10v;
    private String cb11;
    private double cb11v;
    private String cb12;
    private double cb12v;
    private String cb13;
    private double cb13v;
    private String cb14;
    private double cb14v;
    private String cb15;
    private double cb15v;
    private String cb16;
    private double cb16v;
    private String cb17;
    private double cb17v;
    private String cb18;
    private double cb18v;
    private String cb19;
    private double cb19v;
    private String cb20;
    private double cb20v;
    private String cb21;
    private double cb21v;
    private String cb22;
    private double cb22v;
    private String cb23;
    private double cb23v;
    private String cb24;
    private double cb24v;
    private String cb25;
    private double cb25v;
    private String cb26;
    private double cb26v;
    private String cb27;
    private double cb27v;
    private String cb28;
    private double cb28v;
    private String cb29;
    private double cb29v;
    private String cb30;
    private double cb30v;
    private String cb31;
    private double cb31v;
    private String cb32;
    private double cb32v;
    private String cb33;
    private double cb33v;
    private String cb34;
    private double cb34v;
    private String cb35;
    private double cb35v;
    private String cb36;
    private double cb36v;
    private String cb37;
    private double cb37v;
    private String cb38;
    private double cb38v;
    private String cb39;
    private double cb39v;
    private String cb40;
    private double cb40v;
    private String cb41;
    private double cb41v;
    private String cb42;
    private double cb42v;
    private String cb43;
    private double cb43v;
    private String cb44;
    private double cb44v;
    private String cb45;
    private double cb45v;
    private String cb46;
    private double cb46v;
    private String cb47;
    private double cb47v;
    private String cb48;
    private double cb48v;
    private String cb49;
    private double cb49v;
    private String cb50;
    private double cb50v;
    private String cb51;
    private double cb51v;
    private String cb52;
    private double cb52v;
    private String cb53;
    private double cb53v;
    private String cb54;
    private double cb54v;
    private String cb55;
    private double cb55v;
    private String cb56;
    private double cb56v;
    private String cb57;
    private double cb57v;
    private String cb58;
    private double cb58v;
    private String cb59;
    private double cb59v;
    private String cb60;
    private double cb60v;
    //FIXME: Fix Variable Names.
    private String cb65;
    private double cb65v;
    private String cb66;
    private double cb66v;
    private String cb67;
    private double cb67v;
    private String cb68;
    private double cb68v;
    private String cb69;
    private double cb69v;
    private String cb70;
    private double cb70v;
    private String cb71;
    private double cb71v;
    private String cb72;
    private double cb72v;
    private String cb73;
    private double cb73v;


    //FIXME: Fix Variable Names.
    private String Ob7;
    private double Ob7v;
    private String Ob10;
    private double Ob10v;
    private String Ob8;
    private double Ob8v;
    private String Ob9;
    private double Ob9v;
    private String Ob13;
    private double Ob13v;
    private String Ob14;
    private double Ob14v;
    private String Ob11;
    private double Ob11v;
    private String Ob12;
    private double Ob12v;
    private String Ob16;
    private double Ob16v;
    private String Ob15;
    private double Ob15v;
    private String Ob17;
    private double Ob17v;
    private String Ob18;
    private double Ob18v;
    private String Ob19;
    private double Ob19v;
    private String Ob20;
    private double Ob20v;
    private String Ob21;
    private double Ob21v;
    private String Ob22;
    private double Ob22v;
    private String Ob23;
    private double Ob23v;
    private String Ob24;
    private double Ob24v;

    private String recText = "";


    public String getCb73() {
        return cb73;
    }

    public void setCb73(String cb73) {
        this.cb73 = cb73;
    }

    public double getCb73v() {
        return cb73v;
    }

    public void setCb73v(double cb73v) {
        this.cb73v = cb73v;
    }

    public double getOb22v() {
        return Ob22v;
    }

    public void setOb22v(double ob22v) {
        Ob22v = ob22v;
    }

    public String getOb22() {
        return Ob22;
    }

    public void setOb22(String ob22) {
        Ob22 = ob22;
    }

    public double getOb18v() {
        return Ob18v;
    }

    public void setOb18v(double ob18v) {
        Ob18v = ob18v;
    }

    public String getOb18() {
        return Ob18;
    }

    public void setOb18(String ob18) {
        Ob18 = ob18;
    }

    public String getOb14() {
        return Ob14;
    }

    public String getOb17() {
        return Ob17;
    }

    public void setOb17(String ob17) {
        Ob17 = ob17;
    }

    public double getOb17v() {
        return Ob17v;
    }

    public void setOb17v(double ob17v) {
        Ob17v = ob17v;
    }

    public void setOb14(String ob14) {
        Ob14 = ob14;
    }

    public double getOb14v() {
        return Ob14v;
    }

    public void setOb14v(double ob14v) {
        Ob14v = ob14v;
    }

    public double getOb7v() {
        return Ob7v;
    }

    public void setOb7v(double ob7v) {
        Ob7v = ob7v;
    }

    public double getOb10v() {
        return Ob10v;
    }

    public void setOb10v(double ob10v) {
        Ob10v = ob10v;
    }

    public double getOb8v() {
        return Ob8v;
    }

    public void setOb8v(double ob8v) {
        Ob8v = ob8v;
    }

    public double getOb9v() {
        return Ob9v;
    }

    public void setOb9v(double ob9v) {
        Ob9v = ob9v;
    }

    public double getOb13v() {
        return Ob13v;
    }

    public void setOb13v(double ob13v) {
        Ob13v = ob13v;
    }

    public double getOb11v() {
        return Ob11v;
    }

    public void setOb11v(double ob11v) {
        Ob11v = ob11v;
    }

    public double getOb12v() {
        return Ob12v;
    }

    public void setOb12v(double ob12v) {
        Ob12v = ob12v;
    }

    public double getOb16v() {
        return Ob16v;
    }

    public void setOb16v(double ob16v) {
        Ob16v = ob16v;
    }

    public double getOb15v() {
        return Ob15v;
    }

    public void setOb15v(double ob15v) {
        Ob15v = ob15v;
    }

    public double getOb19v() {
        return Ob19v;
    }

    public void setOb19v(double ob19v) {
        Ob19v = ob19v;
    }

    public double getOb20v() {
        return Ob20v;
    }

    public void setOb20v(double ob20v) {
        Ob20v = ob20v;
    }

    public double getOb21v() {
        return Ob21v;
    }

    public void setOb21v(double ob21v) {
        Ob21v = ob21v;
    }

    public double getOb23v() {
        return Ob23v;
    }

    public void setOb23v(double ob23v) {
        Ob23v = ob23v;
    }

    public double getOb24v() {
        return Ob24v;
    }

    public void setOb24v(double ob24v) {
        Ob24v = ob24v;
    }

    public String getOb7() {
        return Ob7;
    }

    public void setOb7(String ob7) {
        Ob7 = ob7;
    }

    public String getOb10() {
        return Ob10;
    }

    public void setOb10(String ob10) {
        Ob10 = ob10;
    }

    public String getOb8() {
        return Ob8;
    }

    public void setOb8(String ob8) {
        Ob8 = ob8;
    }

    public String getOb9() {
        return Ob9;
    }

    public void setOb9(String ob9) {
        Ob9 = ob9;
    }

    public String getOb13() {
        return Ob13;
    }

    public void setOb13(String ob13) {
        Ob13 = ob13;
    }

    public String getOb11() {
        return Ob11;
    }

    public void setOb11(String ob11) {
        Ob11 = ob11;
    }

    public String getOb12() {
        return Ob12;
    }

    public void setOb12(String ob12) {
        Ob12 = ob12;
    }

    public String getOb16() {
        return Ob16;
    }

    public void setOb16(String ob16) {
        Ob16 = ob16;
    }

    public String getOb15() {
        return Ob15;
    }

    public void setOb15(String ob15) {
        Ob15 = ob15;
    }

    public String getOb19() {
        return Ob19;
    }

    public void setOb19(String ob19) {
        Ob19 = ob19;
    }

    public String getOb20() {
        return Ob20;
    }

    public void setOb20(String ob20) {
        Ob20 = ob20;
    }

    public String getOb21() {
        return Ob21;
    }

    public void setOb21(String ob21) {
        Ob21 = ob21;
    }

    public String getOb23() {
        return Ob23;
    }

    public void setOb23(String ob23) {
        Ob23 = ob23;
    }

    public String getOb24() {
        return Ob24;
    }

    public void setOb24(String ob24) {
        Ob24 = ob24;
    }

    public double getTb1() {
        return tb1;
    }

    public void setTb1(double tb1) {
        this.tb1 = tb1;
    }

    public double getTb2() {
        return tb2;
    }

    public void setTb2(double tb2) {
        this.tb2 = tb2;
    }

    public double getTb3() {
        return tb3;
    }

    public void setTb3(double tb3) {
        this.tb3 = tb3;
    }

    public double getTb4() {
        return tb4;
    }

    public void setTb4(double tb4) {
        this.tb4 = tb4;
    }

    public double getTb5() {
        return tb5;
    }

    public void setTb5(double tb5) {
        this.tb5 = tb5;
    }

    public double getTb6() {
        return tb6;
    }

    public void setTb6(double tb6) {
        this.tb6 = tb6;
    }

    public double getTb7() {
        return tb7;
    }

    public void setTb7(double tb7) {
        this.tb7 = tb7;
    }

    public double getTb8() {
        return tb8;
    }

    public void setTb8(double tb8) {
        this.tb8 = tb8;
    }

    public double getTb9() {
        return tb9;
    }

    public void setTb9(double tb9) {
        this.tb9 = tb9;
    }

    public double getTb10() {
        return tb10;
    }

    public void setTb10(double tb10) {
        this.tb10 = tb10;
    }

    public double getTb11() {
        return tb11;
    }

    public void setTb11(double tb11) {
        this.tb11 = tb11;
    }

    public double getTb12() {
        return tb12;
    }

    public void setTb12(double tb12) {
        this.tb12 = tb12;
    }

    public double getTb13() {
        return tb13;
    }

    public void setTb13(double tb13) {
        this.tb13 = tb13;
    }

    public double getTb14() {
        return tb14;
    }

    public void setTb14(double tb14) {
        this.tb14 = tb14;
    }

    public double getTb15() {
        return tb15;
    }

    public void setTb15(double tb15) {
        this.tb15 = tb15;
    }

    public double getTb16() {
        return tb16;
    }

    public void setTb16(double tb16) {
        this.tb16 = tb16;
    }

    public double getTb17() {
        return tb17;
    }

    public void setTb17(double tb17) {
        this.tb17 = tb17;
    }

    public double getTb18() {
        return tb18;
    }

    public void setTb18(double tb18) {
        this.tb18 = tb18;
    }

    public double getTb19() {
        return tb19;
    }

    public void setTb19(double tb19) {
        this.tb19 = tb19;
    }

    public double getTb20() {
        return tb20;
    }

    public void setTb20(double tb20) {
        this.tb20 = tb20;
    }

    public double getTb21() {
        return tb21;
    }

    public void setTb21(double tb21) {
        this.tb21 = tb21;
    }

    public double getTb22() {
        return tb22;
    }

    public void setTb22(double tb22) {
        this.tb22 = tb22;
    }

    public double getTb23() {
        return tb23;
    }

    public void setTb23(double tb23) {
        this.tb23 = tb23;
    }

    public double getTb24() {
        return tb24;
    }

    public void setTb24(double tb24) {
        this.tb24 = tb24;
    }

    public double getTb25() {
        return tb25;
    }

    public void setTb25(double tb25) {
        this.tb25 = tb25;
    }

    public double getTb26() {
        return tb26;
    }

    public void setTb26(double tb26) {
        this.tb26 = tb26;
    }

    public double getTb27() {
        return tb27;
    }

    public void setTb27(double tb27) {
        this.tb27 = tb27;
    }

    public double getTb28() {
        return tb28;
    }

    public void setTb28(double tb28) {
        this.tb28 = tb28;
    }

    public double getTb29() {
        return tb29;
    }

    public void setTb29(double tb29) {
        this.tb29 = tb29;
    }

    public double getTb30() {
        return tb30;
    }

    public void setTb30(double tb30) {
        this.tb30 = tb30;
    }

    public double getTb31() {
        return tb31;
    }

    public void setTb31(double tb31) {
        this.tb31 = tb31;
    }

    public double getTb33() {
        return tb33;
    }

    public void setTb33(double tb33) {
        this.tb33 = tb33;
    }

    public double getTb34() {
        return tb34;
    }

    public void setTb34(double tb34) {
        this.tb34 = tb34;
    }

    public double getTb35() {
        return tb35;
    }

    public void setTb35(double tb35) {
        this.tb35 = tb35;
    }

    public double getTb36() {
        return tb36;
    }

    public void setTb36(double tb36) {
        this.tb36 = tb36;
    }

    public String getCb1() {
        return cb1;
    }

    public void setCb1(String cb1) {
        this.cb1 = cb1;
    }

    public String getCb2() {
        return cb2;
    }

    public void setCb2(String cb2) {
        this.cb2 = cb2;
    }

    public String getCb3() {
        return cb3;
    }

    public void setCb3(String cb3) {
        this.cb3 = cb3;
    }

    public String getCb4() {
        return cb4;
    }

    public void setCb4(String cb4) {
        this.cb4 = cb4;
    }

    public String getCb5() {
        return cb5;
    }

    public void setCb5(String cb5) {
        this.cb5 = cb5;
    }

    public String getCb6() {
        return cb6;
    }

    public void setCb6(String cb6) {
        this.cb6 = cb6;
    }

    public String getCb7() {
        return cb7;
    }

    public void setCb7(String cb7) {
        this.cb7 = cb7;
    }

    public String getCb8() {
        return cb8;
    }

    public void setCb8(String cb8) {
        this.cb8 = cb8;
    }

    public String getCb9() {
        return cb9;
    }

    public void setCb9(String cb9) {
        this.cb9 = cb9;
    }

    public String getCb10() {
        return cb10;
    }

    public void setCb10(String cb10) {
        this.cb10 = cb10;
    }

    public String getCb11() {
        return cb11;
    }

    public void setCb11(String cb11) {
        this.cb11 = cb11;
    }

    public String getCb12() {
        return cb12;
    }

    public void setCb12(String cb12) {
        this.cb12 = cb12;
    }

    public String getCb13() {
        return cb13;
    }

    public void setCb13(String cb13) {
        this.cb13 = cb13;
    }

    public String getCb14() {
        return cb14;
    }

    public void setCb14(String cb14) {
        this.cb14 = cb14;
    }

    public String getCb15() {
        return cb15;
    }

    public void setCb15(String cb15) {
        this.cb15 = cb15;
    }

    public String getCb16() {
        return cb16;
    }

    public void setCb16(String cb16) {
        this.cb16 = cb16;
    }

    public String getCb17() {
        return cb17;
    }

    public void setCb17(String cb17) {
        this.cb17 = cb17;
    }

    public String getCb18() {
        return cb18;
    }

    public void setCb18(String cb18) {
        this.cb18 = cb18;
    }

    public String getCb19() {
        return cb19;
    }

    public void setCb19(String cb19) {
        this.cb19 = cb19;
    }

    public String getCb20() {
        return cb20;
    }

    public void setCb20(String cb20) {
        this.cb20 = cb20;
    }

    public String getCb21() {
        return cb21;
    }

    public void setCb21(String cb21) {
        this.cb21 = cb21;
    }

    public String getCb22() {
        return cb22;
    }

    public void setCb22(String cb22) {
        this.cb22 = cb22;
    }

    public String getCb23() {
        return cb23;
    }

    public void setCb23(String cb23) {
        this.cb23 = cb23;
    }

    public String getCb24() {
        return cb24;
    }

    public void setCb24(String cb24) {
        this.cb24 = cb24;
    }

    public String getCb25() {
        return cb25;
    }

    public void setCb25(String cb25) {
        this.cb25 = cb25;
    }

    public String getCb26() {
        return cb26;
    }

    public void setCb26(String cb26) {
        this.cb26 = cb26;
    }

    public String getCb27() {
        return cb27;
    }

    public void setCb27(String cb27) {
        this.cb27 = cb27;
    }

    public String getCb28() {
        return cb28;
    }

    public void setCb28(String cb28) {
        this.cb28 = cb28;
    }

    public String getCb29() {
        return cb29;
    }

    public void setCb29(String cb29) {
        this.cb29 = cb29;
    }

    public String getCb30() {
        return cb30;
    }

    public void setCb30(String cb30) {
        this.cb30 = cb30;
    }

    public String getCb31() {
        return cb31;
    }

    public void setCb31(String cb31) {
        this.cb31 = cb31;
    }

    public String getCb32() {
        return cb32;
    }

    public void setCb32(String cb32) {
        this.cb32 = cb32;
    }

    public String getCb33() {
        return cb33;
    }

    public void setCb33(String cb33) {
        this.cb33 = cb33;
    }

    public String getCb34() {
        return cb34;
    }

    public void setCb34(String cb34) {
        this.cb34 = cb34;
    }

    public String getCb35() {
        return cb35;
    }

    public void setCb35(String cb35) {
        this.cb35 = cb35;
    }

    public String getCb36() {
        return cb36;
    }

    public void setCb36(String cb36) {
        this.cb36 = cb36;
    }

    public String getCb37() {
        return cb37;
    }

    public void setCb37(String cb37) {
        this.cb37 = cb37;
    }

    public String getCb38() {
        return cb38;
    }

    public void setCb38(String cb38) {
        this.cb38 = cb38;
    }

    public String getCb39() {
        return cb39;
    }

    public void setCb39(String cb39) {
        this.cb39 = cb39;
    }

    public String getCb40() {
        return cb40;
    }

    public void setCb40(String cb40) {
        this.cb40 = cb40;
    }

    public String getCb41() {
        return cb41;
    }

    public void setCb41(String cb41) {
        this.cb41 = cb41;
    }

    public String getCb42() {
        return cb42;
    }

    public void setCb42(String cb42) {
        this.cb42 = cb42;
    }

    public String getCb43() {
        return cb43;
    }

    public void setCb43(String cb43) {
        this.cb43 = cb43;
    }

    public String getCb44() {
        return cb44;
    }

    public void setCb44(String cb44) {
        this.cb44 = cb44;
    }

    public String getCb45() {
        return cb45;
    }

    public void setCb45(String cb45) {
        this.cb45 = cb45;
    }

    public String getCb46() {
        return cb46;
    }

    public void setCb46(String cb46) {
        this.cb46 = cb46;
    }

    public String getCb47() {
        return cb47;
    }

    public void setCb47(String cb47) {
        this.cb47 = cb47;
    }

    public String getCb48() {
        return cb48;
    }

    public void setCb48(String cb48) {
        this.cb48 = cb48;
    }

    public String getCb49() {
        return cb49;
    }

    public void setCb49(String cb49) {
        this.cb49 = cb49;
    }

    public String getCb50() {
        return cb50;
    }

    public void setCb50(String cb50) {
        this.cb50 = cb50;
    }

    public String getCb51() {
        return cb51;
    }

    public void setCb51(String cb51) {
        this.cb51 = cb51;
    }

    public String getCb52() {
        return cb52;
    }

    public void setCb52(String cb52) {
        this.cb52 = cb52;
    }

    public String getCb53() {
        return cb53;
    }

    public void setCb53(String cb53) {
        this.cb53 = cb53;
    }

    public String getCb54() {
        return cb54;
    }

    public void setCb54(String cb54) {
        this.cb54 = cb54;
    }

    public String getCb55() {
        return cb55;
    }

    public void setCb55(String cb55) {
        this.cb55 = cb55;
    }

    public String getCb56() {
        return cb56;
    }

    public void setCb56(String cb56) {
        this.cb56 = cb56;
    }

    public String getCb57() {
        return cb57;
    }

    public void setCb57(String cb57) {
        this.cb57 = cb57;
    }

    public String getCb58() {
        return cb58;
    }

    public void setCb58(String cb58) {
        this.cb58 = cb58;
    }

    public String getCb59() {
        return cb59;
    }

    public void setCb59(String cb59) {
        this.cb59 = cb59;
    }

    public String getCb60() {
        return cb60;
    }

    public void setCb60(String cb60) {
        this.cb60 = cb60;
    }

    // ///////////////////////
    // Risk Sum Assured
    // ///////////////////////
    // Page 1
    // Governance Structure
    // Composition & Competency of the Board
    // Board Orientation & Education
    // Page 2
    // Board Assessment & Breach of Code of Conduct
    // Internal Controls & Governance Mechanisms
    // Page 3
    // Expert Advisors
    // Risk Management
    // Page 4
    // Investment Performance of the Fund Assets
    // Communication and Access to Information
    // ////////////////////////////////////////////////////////////////////

    public double getCb1v() {
        return cb1v;
    }

    public void setCb1v(double cb1v) {
        this.cb1v = cb1v;
    }

    public double getCb2v() {
        return cb2v;
    }

    public void setCb2v(double cb2v) {
        this.cb2v = cb2v;
    }

    public double getCb3v() {
        return cb3v;
    }

    public void setCb3v(double cb3v) {
        this.cb3v = cb3v;
    }

    public double getCb4v() {
        return cb4v;
    }

    public void setCb4v(double cb4v) {
        this.cb4v = cb4v;
    }

    public double getCb5v() {
        return cb5v;
    }

    public void setCb5v(double cb5v) {
        this.cb5v = cb5v;
    }

    public double getCb6v() {
        return cb6v;
    }

    public void setCb6v(double cb6v) {
        this.cb6v = cb6v;
    }

    public double getCb7v() {
        return cb7v;
    }

    public void setCb7v(double cb7v) {
        this.cb7v = cb7v;
    }

    public double getCb8v() {
        return cb8v;
    }

    public void setCb8v(double cb8v) {
        this.cb8v = cb8v;
    }

    public double getCb9v() {
        return cb9v;
    }

    public void setCb9v(double cb9v) {
        this.cb9v = cb9v;
    }

    public double getCb10v() {
        return cb10v;
    }

    public void setCb10v(double cb10v) {
        this.cb10v = cb10v;
    }

    public double getCb11v() {
        return cb11v;
    }

    public void setCb11v(double cb11v) {
        this.cb11v = cb11v;
    }

    public double getCb12v() {
        return cb12v;
    }

    public void setCb12v(double cb12v) {
        this.cb12v = cb12v;
    }

    public double getCb13v() {
        return cb13v;
    }

    public void setCb13v(double cb13v) {
        this.cb13v = cb13v;
    }

    public double getCb14v() {
        return cb14v;
    }

    public void setCb14v(double cb14v) {
        this.cb14v = cb14v;
    }

    public double getCb15v() {
        return cb15v;
    }

    public void setCb15v(double cb15v) {
        this.cb15v = cb15v;
    }

    public double getCb16v() {
        return cb16v;
    }

    public void setCb16v(double cb16v) {
        this.cb16v = cb16v;
    }

    public double getCb17v() {
        return cb17v;
    }

    public void setCb17v(double cb17v) {
        this.cb17v = cb17v;
    }

    public double getCb18v() {
        return cb18v;
    }

    public void setCb18v(double cb18v) {
        this.cb18v = cb18v;
    }

    public double getCb19v() {
        return cb19v;
    }

    public void setCb19v(double cb19v) {
        this.cb19v = cb19v;
    }

    public double getCb20v() {
        return cb20v;
    }

    public void setCb20v(double cb20v) {
        this.cb20v = cb20v;
    }

    public double getCb21v() {
        return cb21v;
    }

    public void setCb21v(double cb21v) {
        this.cb21v = cb21v;
    }

    public double getCb22v() {
        return cb22v;
    }

    public void setCb22v(double cb22v) {
        this.cb22v = cb22v;
    }

    public double getCb23v() {
        return cb23v;
    }

    public void setCb23v(double cb23v) {
        this.cb23v = cb23v;
    }

    public double getCb24v() {
        return cb24v;
    }

    public void setCb24v(double cb24v) {
        this.cb24v = cb24v;
    }

    public double getCb25v() {
        return cb25v;
    }

    public void setCb25v(double cb25v) {
        this.cb25v = cb25v;
    }

    public double getCb26v() {
        return cb26v;
    }

    public void setCb26v(double cb26v) {
        this.cb26v = cb26v;
    }

    public double getCb27v() {
        return cb27v;
    }

    public void setCb27v(double cb27v) {
        this.cb27v = cb27v;
    }

    public double getCb28v() {
        return cb28v;
    }

    public void setCb28v(double cb28v) {
        this.cb28v = cb28v;
    }

    public double getCb29v() {
        return cb29v;
    }

    public void setCb29v(double cb29v) {
        this.cb29v = cb29v;
    }

    public double getCb30v() {
        return cb30v;
    }

    public void setCb30v(double cb30v) {
        this.cb30v = cb30v;
    }

    public double getCb31v() {
        return cb31v;
    }

    public void setCb31v(double cb31v) {
        this.cb31v = cb31v;
    }

    public double getCb32v() {
        return cb32v;
    }

    public void setCb32v(double cb32v) {
        this.cb32v = cb32v;
    }

    public double getCb33v() {
        return cb33v;
    }

    public void setCb33v(double cb33v) {
        this.cb33v = cb33v;
    }

    public double getCb34v() {
        return cb34v;
    }

    public void setCb34v(double cb34v) {
        this.cb34v = cb34v;
    }

    public double getCb35v() {
        return cb35v;
    }

    public void setCb35v(double cb35v) {
        this.cb35v = cb35v;
    }

    public double getCb36v() {
        return cb36v;
    }

    public void setCb36v(double cb36v) {
        this.cb36v = cb36v;
    }

    public double getCb37v() {
        return cb37v;
    }

    public void setCb37v(double cb37v) {
        this.cb37v = cb37v;
    }

    public double getCb38v() {
        return cb38v;
    }

    public void setCb38v(double cb38v) {
        this.cb38v = cb38v;
    }

    public double getCb39v() {
        return cb39v;
    }

    public void setCb39v(double cb39v) {
        this.cb39v = cb39v;
    }

    public double getCb40v() {
        return cb40v;
    }

    public void setCb40v(double cb40v) {
        this.cb40v = cb40v;
    }

    public double getCb41v() {
        return cb41v;
    }

    public void setCb41v(double cb41v) {
        this.cb41v = cb41v;
    }

    public double getCb42v() {
        return cb42v;
    }

    public void setCb42v(double cb42v) {
        this.cb42v = cb42v;
    }

    public double getCb43v() {
        return cb43v;
    }

    public void setCb43v(double cb43v) {
        this.cb43v = cb43v;
    }

    public double getCb44v() {
        return cb44v;
    }

    public void setCb44v(double cb44v) {
        this.cb44v = cb44v;
    }

    public double getCb45v() {
        return cb45v;
    }

    public void setCb45v(double cb45v) {
        this.cb45v = cb45v;
    }

    public double getCb46v() {
        return cb46v;
    }

    public void setCb46v(double cb46v) {
        this.cb46v = cb46v;
    }

    public double getCb47v() {
        return cb47v;
    }

    public void setCb47v(double cb47v) {
        this.cb47v = cb47v;
    }

    public double getCb48v() {
        return cb48v;
    }

    public void setCb48v(double cb48v) {
        this.cb48v = cb48v;
    }

    public double getCb49v() {
        return cb49v;
    }

    public void setCb49v(double cb49v) {
        this.cb49v = cb49v;
    }

    public double getCb50v() {
        return cb50v;
    }

    public void setCb50v(double cb50v) {
        this.cb50v = cb50v;
    }

    public double getCb51v() {
        return cb51v;
    }

    public void setCb51v(double cb51v) {
        this.cb51v = cb51v;
    }

    public double getCb52v() {
        return cb52v;
    }

    public void setCb52v(double cb52v) {
        this.cb52v = cb52v;
    }

    public double getCb53v() {
        return cb53v;
    }

    public void setCb53v(double cb53v) {
        this.cb53v = cb53v;
    }

    public double getCb54v() {
        return cb54v;
    }

    public void setCb54v(double cb54v) {
        this.cb54v = cb54v;
    }

    public double getCb55v() {
        return cb55v;
    }

    public void setCb55v(double cb55v) {
        this.cb55v = cb55v;
    }

    public double getCb56v() {
        return cb56v;
    }

    public void setCb56v(double cb56v) {
        this.cb56v = cb56v;
    }

    public double getCb57v() {
        return cb57v;
    }

    public void setCb57v(double cb57v) {
        this.cb57v = cb57v;
    }

    public double getCb58v() {
        return cb58v;
    }

    public void setCb58v(double cb58v) {
        this.cb58v = cb58v;
    }

    public double getCb59v() {
        return cb59v;
    }

    public void setCb59v(double cb59v) {
        this.cb59v = cb59v;
    }

    public double getCb60v() {
        return cb60v;
    }

    public void setCb60v(double cb60v) {
        this.cb60v = cb60v;
    }

    public String getCb65() {
        return cb65;
    }

    public void setCb65(String cb65) {
        this.cb65 = cb65;
    }

    public double getCb65v() {
        return cb65v;
    }

    public void setCb65v(double cb65v) {
        this.cb65v = cb65v;
    }

    public String getCb66() {
        return cb66;
    }

    public void setCb66(String cb66) {
        this.cb66 = cb66;
    }

    public double getCb66v() {
        return cb66v;
    }

    public void setCb66v(double cb66v) {
        this.cb66v = cb66v;
    }

    public String getCb67() {
        return cb67;
    }

    public void setCb67(String cb67) {
        this.cb67 = cb67;
    }

    public double getCb67v() {
        return cb67v;
    }

    public void setCb67v(double cb67v) {
        this.cb67v = cb67v;
    }

    public String getCb68() {
        return cb68;
    }

    public void setCb68(String cb68) {
        this.cb68 = cb68;
    }

    public double getCb68v() {
        return cb68v;
    }

    public void setCb68v(double cb68v) {
        this.cb68v = cb68v;
    }

    public String getCb69() {
        return cb69;
    }

    public void setCb69(String cb69) {
        this.cb69 = cb69;
    }

    public double getCb69v() {
        return cb69v;
    }

    public void setCb69v(double cb69v) {
        this.cb69v = cb69v;
    }

    public String getCb70() {
        return cb70;
    }

    public void setCb70(String cb70) {
        this.cb70 = cb70;
    }

    public double getCb70v() {
        return cb70v;
    }

    public void setCb70v(double cb70v) {
        this.cb70v = cb70v;
    }

    public String getCb71() {
        return cb71;
    }

    public void setCb71(String cb71) {
        this.cb71 = cb71;
    }

    public double getCb71v() {
        return cb71v;
    }

    public void setCb71v(double cb71v) {
        this.cb71v = cb71v;
    }

    public String getCb72() {
        return cb72;
    }

    public void setCb72(String cb72) {
        this.cb72 = cb72;
    }

    public double getCb72v() {
        return cb72v;
    }

    public void setCb72v(double cb72v) {
        this.cb72v = cb72v;
    }

    Calendar c = new GregorianCalendar();

    //The Long Version...
    public void calculate_long_loading() {
        logger.log(Level.FINEST, "Long Loading Calc Start");
        //The other calculation are done in the Wizard descriptor.
        //String dateToday = DateFormat.getDateInstance().format(Calendar.getInstance().getTime());

        DecimalFormat form = new DecimalFormat("#### ### ### ###");

        //tb31 = tb1 + tb2 + tb3 + tb4 + tb5 + tb6 + tb7 + tb8 + tb9 + tb10
        //		+ tb11 + tb12+ tb13 + tb14 + tb15 + tb16 + tb18 + tb18 + tb19 + tb20
        //       + tb21 + tb22 + tb23 + tb24 + tb25 + tb26 + tb27 + tb28 + tb29 + tb30;
        tb31 = tb1 + tb2 + tb3 + tb4 + tb5 + tb6 + tb7 + tb8 + tb9 + tb10 + tb11 + tb12 + tb13 + tb14 + tb15 + tb16 + tb18 + tb18 + tb19 + tb20
                + tb21 + tb22 + tb23 + tb24 + tb25 + tb27 + tb28 + tb29 + tb30 + tb33 + tb34 + tb35 + tb36;

        double loading = tb31;
        logger.log(Level.FINEST, "Loading: " + loading);

        long adjustedCover = (((int) (this.minCover * (1 + tb31)) / 500000) * 500000);
        logger.log(Level.FINEST, "Adjusted Cover: " + adjustedCover);

        if (adjustedCover <= this.minCover)
            recText = "there is no need for the recommended cover to be increased for above-average risk.";
        else
            recText = "the recommended cover should be increased to R" + dformat(adjustedCover) + ".";


        createModel();
        //From Another Form
        model.put("cb1", (cb1));
        model.put("cb2", (cb2));
        model.put("cb3", (cb3));
        model.put("cb4", (cb4));
        model.put("cb5", (cb5));
        model.put("cb6", (cb6));
        model.put("cb7", (cb7));
        model.put("cb8", (cb8));
        model.put("cb9", (cb9));
        model.put("cb10", (cb10));
        model.put("cb11", (cb11));
        model.put("cb12", (cb12));
        //
        model.put("cb13", (cb13));
        model.put("cb14", (cb14));
        model.put("cb15", (cb15));
        model.put("cb16", (cb16));
        model.put("cb17", (cb17));
        model.put("cb18", (cb18));
        model.put("cb19", (cb19));
        model.put("cb20", (cb20));

        model.put("cb21", (cb21));
        model.put("cb22", (cb22));
        model.put("cb23", (cb23));
        model.put("cb24", (cb24));
        model.put("cb25", (cb25));
        model.put("cb26", (cb26));
        model.put("cb27", (cb27));
        model.put("cb28", (cb28));
        model.put("cb29", (cb29));
        model.put("cb30", (cb30));

        model.put("cb31", (cb31));
        model.put("cb32", (cb32));
        model.put("cb33", (cb33));
        model.put("cb34", (cb34));
        model.put("cb35", (cb35));
        model.put("cb36", (cb36));
        model.put("cb37", (cb37));
        model.put("cb38", (cb38));
        model.put("cb39", (cb39));
        model.put("cb40", (cb40));

        model.put("cb41", (cb41));
        model.put("cb42", (cb42));
        model.put("cb43", (cb43));
        model.put("cb44", (cb44));
        model.put("cb45", (cb45));
        model.put("cb46", (cb46));
        model.put("cb47", (cb47));
        model.put("cb48", (cb48));
        model.put("cb49", (cb49));
        model.put("cb50", (cb50));

        model.put("cb51", (cb51));
        model.put("cb52", (cb52));
        model.put("cb53", (cb53));
        model.put("cb54", (cb54));
        model.put("cb55", (cb55));
        model.put("cb56", (cb56));
        model.put("cb57", (cb57));
        model.put("cb58", (cb58));
        model.put("cb59", (cb59));
        model.put("cb60", (cb60));

        //model.put("cb51", (cb61));
        //model.put("cb52", (cb62));
        //model.put("cb53", (cb63));
        //model.put("cb54", (cb64));
        model.put("cb65", (cb65));
        model.put("cb66", (cb66));
        model.put("cb67", (cb67));
        model.put("cb68", (cb68));
        model.put("cb69", (cb69));
        model.put("cb70", (cb70));

        model.put("cb71", (cb71));
        model.put("cb72", (cb72));
        model.put("cb73", (cb73));

        model.put("tb1", pformatter.format(tb1));
        model.put("tb2", pformatter.format(tb2));
        model.put("tb3", pformatter.format(tb3));
        model.put("tb4", pformatter.format(tb4));
        model.put("tb5", pformatter.format(tb5));
        model.put("tb6", pformatter.format(tb6));
        model.put("tb7", pformatter.format(tb7));
        model.put("tb8", pformatter.format(tb8));
        model.put("tb9", pformatter.format(tb9));
        model.put("tb10", pformatter.format(tb10));

        model.put("tb11", pformatter.format(tb11));
        model.put("tb12", pformatter.format(tb12));
        model.put("tb13", pformatter.format(tb13));
        model.put("tb14", pformatter.format(tb14));
        model.put("tb15", pformatter.format(tb15));
        model.put("tb16", pformatter.format(tb16));
        model.put("tb17", pformatter.format(tb17));
        model.put("tb18", pformatter.format(tb18));
        model.put("tb19", pformatter.format(tb19));
        model.put("tb20", pformatter.format(tb20));

        model.put("tb21", pformatter.format(tb21));
        model.put("tb22", pformatter.format(tb22));
        model.put("tb23", pformatter.format(tb23));
        model.put("tb24", pformatter.format(tb24));
        model.put("tb25", pformatter.format(tb25));
        model.put("tb26", pformatter.format(tb26));
        model.put("tb27", pformatter.format(tb27));
        model.put("tb28", pformatter.format(tb28));
        model.put("tb29", pformatter.format(tb29));
        model.put("tb30", pformatter.format(tb30));
        model.put("tb31", pformatter.format(tb31));

        model.put("tb33", pformatter.format(tb33));
        model.put("tb34", pformatter.format(tb34));
        model.put("tb35", pformatter.format(tb35));
        model.put("tb36", pformatter.format(tb36));

        model.put("RecText", recText);

    }

    //The Long Version...
    public void calculate_short_loading() {
        //The other calculation are done in the Wizard descriptor.
        tb12 = tb3 + tb4 + tb5 + tb6 + tb7 + tb8 + tb9 + tb10 + tb11;

        //caluclate_fund_data MUST be called first before this method since its needed.
        long adjustedCover = (((int) (this.minCover * (1 + tb12)) / 500000) * 500000);
        logger.log(Level.FINEST, "Adjusted Cover: " + adjustedCover);

        if (adjustedCover <= this.minCover)
            recText = "there is no need for the recommended cover to be increased for above-average risk.";
        else
            recText = "the recommended cover should be increased to R" + dformat(adjustedCover) + ".";

        createModel();

        model.put("ob7", Ob7);
        model.put("ob7v", dformat(Ob7v));
        model.put("ob10", Ob10);
        model.put("ob10v", dformat(Ob10v));
        model.put("tb3", pformatter.format(tb3));

        model.put("ob8", Ob8);
        model.put("ob8v", dformat(Ob8v));
        model.put("ob11", Ob11);
        model.put("ob11v", dformat(Ob11v));
        model.put("tb4", pformatter.format(tb4));

        model.put("ob9", Ob9);
        model.put("ob9v", dformat(Ob9v));
        model.put("ob12", Ob12);
        model.put("ob12v", dformat(Ob12v));
        model.put("tb5", pformatter.format(tb5));

        model.put("ob13", Ob13);
        model.put("ob13v", dformat(Ob13v));
        model.put("ob14", Ob14);
        model.put("ob14v", dformat(Ob14v));
        model.put("tb6", pformatter.format(tb6));

        model.put("ob15", Ob15);
        model.put("ob15v", dformat(Ob15v));
        model.put("ob16", Ob16);
        model.put("ob16v", dformat(Ob16v));
        model.put("tb7", pformatter.format(tb7));

        model.put("ob17", Ob17);
        model.put("ob17v", dformat(Ob17v));
        model.put("ob18", Ob18);
        model.put("ob18v", dformat(Ob18v));
        model.put("tb8", pformatter.format(tb8));

        model.put("ob19", Ob19);
        model.put("ob19v", dformat(Ob19v));
        model.put("ob20", Ob20);
        model.put("ob20v", dformat(Ob20v));
        model.put("tb9", pformatter.format(tb9));

        model.put("ob21", Ob21);
        model.put("ob21v", dformat(Ob21v));
        model.put("ob22", Ob22);
        model.put("ob22v", dformat(Ob22v));
        model.put("tb10", pformatter.format(tb10));

        model.put("ob23", Ob23);
        model.put("ob23v", dformat(Ob23v));
        model.put("ob24", Ob24);
        model.put("ob24v", dformat(Ob24v));
        model.put("tb11", pformatter.format(tb11));
        model.put("tb12", pformatter.format(tb12));

        model.put("RecText", recText);
    }

    public void calculate_fund_data() {
        //Seems right
        averageDeathBens = (Db1 + Db2 + Db3 + Db4 + Db5 + Db6 + Db7 + Db8 + Db9 + Db10) / noDeathBens;
        logger.log(Level.FINEST, "Average Death Benefits: " + averageDeathBens);
        averageMemberShare = (Ms1 + Ms2 + Ms3 + Ms4 + Ms5 + Ms6 + Ms7 + Ms8 + Ms9 + Ms10) / noMbrShares;
        logger.log(Level.FINEST, "Average Member Share: " + averageMemberShare);

        topDeath1 = Db1;
        topShare1 = Ms1;

        logger.log(Level.FINEST, "Top Death: " + topDeath1);
        logger.log(Level.FINEST, "Top Share: " + topShare1);

        this.minCover = (topDeath1 + topShare1 + averageDeathBens + averageMemberShare + ((long) (0.05 * annCons + 0.01 * valInvest))) / 5 + 1000000;
        logger.log(Level.FINEST, "Min Cover: " + minCover);

        rndMinCover = ((int) (minCover / 500000)) * 500000;

        createModel();
        //Assign Vars for RTF File.
        model.put("FundName", fundName);
        model.put("EffectiveDate", dateFormat1.format(effectiveDate));
        model.put("CoverFrom", dateFormat1.format(coverFrom));
        model.put("CoverTo", dateFormat1.format(coverTo));
        model.put("RetroDate", dateFormat1.format(retroDate));
        model.put("InForceCover", dformat(indemnityLimit));
        model.put("AnnualPremium", dformat(annPremium));
        model.put("Excess", dformat(firstAmount));
        if (claimsYN == true)
            model.put("ClaimsYN", "Yes");
        else
            model.put("ClaimsYN", "No");
        model.put("HighestClaim", dformat(highClaim));
        model.put("AggregateClaim", dformat(aggClaim));
        model.put("MemberNumber", noMembers);
        model.put("AnnualCons", dformat(annCons));
        model.put("InvestmentValue", dformat(valInvest));
        model.put("TopDth1", dformat(Db1));
        model.put("TopDth2", dformat(Db2));
        model.put("TopDth3", dformat(Db3));
        model.put("TopDth4", dformat(Db4));
        model.put("TopDth5", dformat(Db5));
        model.put("TopDth6", dformat(Db6));
        model.put("TopDth7", dformat(Db7));
        model.put("TopDth8", dformat(Db8));
        model.put("TopDth9", dformat(Db9));
        model.put("TopDth10", dformat(Db10));
        model.put("AverageTopTenDeathBens", dformat(averageDeathBens));
        model.put("TopShare1", dformat(Ms1));
        model.put("TopShare2", dformat(Ms2));
        model.put("TopShare3", dformat(Ms3));
        model.put("TopShare4", dformat(Ms4));
        model.put("TopShare5", dformat(Ms5));
        model.put("TopShare6", dformat(Ms6));
        model.put("TopShare7", dformat(Ms7));
        model.put("TopShare8", dformat(Ms8));
        model.put("TopShare9", dformat(Ms9));
        model.put("TopShare10", dformat(Ms10));
        model.put("AverageTopTenMemberShares", dformat(averageMemberShare));
        model.put("TopMemberShareLoss", Ms1 * 0.2);
        model.put("MinimumCover", dformat(rndMinCover));

        //Others
        model.put("DateToday", dateFormat1.format(Calendar.getInstance().getTime())); //dateToday
        model.put("Date", dateFormat1.format(Calendar.getInstance().getTime())); //dateToday
    }

    public void createModel() {
        if (this.model == null)
            this.model = new HashMap<String, Object>();
    }

    public void populateWithTestData() {
        logger.log(Level.FINEST, "Populating With Test Data");

        this.fundName = "The Test Umbrella Provident Fund";
        c.clear();
        c.set(2011, 6, 31); //31 July 2011

        this.effectiveDate = c.getTime();

        c.clear();
        c.set(2010, 7, 1); //01/07/2010
        this.coverFrom = c.getTime();

        c.clear();
        c.set(2011, 6, 30); //30/06/2011
        this.coverTo = c.getTime();

        c.clear();
        c.set(2009, 7, 1); //01/07/2009
        this.retroDate = c.getTime();

        this.preservationFund = false;
        this.investmentChoice = true;

        this.partEmp = 15;
        this.noPortfolios = 6;
        this.indemnityLimit = 2000000;
        this.annPremium = 12000;
        this.firstAmount = 100000;
        this.claimsYN = true;
        this.highClaim = 350000;
        this.aggClaim = 650000;
        this.noMembers = 3600;
        this.annCons = 48850000;
        this.valInvest = 210000000;

        this.noDeathBens = 9;
        this.Db1 = 15050000;
        this.Db2 = 14310000;
        this.Db3 = 12550000;
        this.Db4 = 12270000;
        this.Db5 = 11670000;
        this.Db6 = 11300000;
        this.Db7 = 11270000;
        this.Db8 = 7980000;
        this.Db9 = 7800000;
        this.Db10 = 7690000;

        this.noMbrShares = 9;
        this.Ms1 = 13800000;
        this.Ms2 = 6790000;
        this.Ms3 = 3070000;
        this.Ms4 = 2770000;
        this.Ms5 = 2630000;
        this.Ms6 = 2590000;
        this.Ms7 = 2500000;
        this.Ms8 = 2490000;
        this.Ms9 = 2150000;
        this.Ms10 = 2020000;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public NumberFormat getPformatter() {
        return pformatter;
    }

    public void setPformatter(NumberFormat pformatter) {
        this.pformatter = pformatter;
    }

    public String getFundName() {
        return this.fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public Boolean getPreservationFund() {
        return preservationFund;
    }

    public void setPreservationFund(Boolean preservationFund) {
        this.preservationFund = preservationFund;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public int getPartEmp() {
        return partEmp;
    }

    public void setPartEmp(int partEmp) {
        this.partEmp = partEmp;
    }

    public Boolean getInvestmentChoice() {
        return investmentChoice;
    }

    public void setInvestmentChoice(Boolean investmentChoice) {
        this.investmentChoice = investmentChoice;
    }

    public int getNoPortfolios() {
        return noPortfolios;
    }

    public void setNoPortfolios(int noPortfolios) {
        this.noPortfolios = noPortfolios;
    }

    public Date getCoverFrom() {
        return coverFrom;
    }

    public void setCoverFrom(Date coverFrom) {
        this.coverFrom = coverFrom;
    }

    public Date getCoverTo() {
        return coverTo;
    }

    public void setCoverTo(Date coverTo) {
        this.coverTo = coverTo;
    }

    public Date getRetroDate() {
        return retroDate;
    }

    public void setRetroDate(Date retroDate) {
        this.retroDate = retroDate;
    }

    public double getAnnPremium() {
        return annPremium;
    }

    public void setAnnPremium(long annPremium) {
        this.annPremium = annPremium;
    }

    public Boolean getClaimsYN() {
        return claimsYN;
    }

    public void setClaimsYN(Boolean claimsYN) {
        this.claimsYN = claimsYN;
    }

    public long getIndemnityLimit() {
        return indemnityLimit;
    }

    public void setIndemnityLimit(long indemnityLimit) {
        this.indemnityLimit = indemnityLimit;
    }

    public long getHighClaim() {
        return highClaim;
    }

    public void setHighClaim(long highClaim) {
        this.highClaim = highClaim;
    }

    public long getFirstAmount() {
        return firstAmount;
    }

    public void setFirstAmount(long firstAmount) {
        this.firstAmount = firstAmount;
    }

    public long getAggClaim() {
        return aggClaim;
    }

    public void setAggClaim(long aggClaim) {
        this.aggClaim = aggClaim;
    }

    public int getNoMembers() {
        return noMembers;
    }

    public void setNoMembers(int noMembers) {
        this.noMembers = noMembers;
    }

    public long getAnnCons() {
        return annCons;
    }

    public void setAnnCons(long annCons) {
        this.annCons = annCons;
    }

    public long getValInvest() {
        return valInvest;
    }

    public void setValInvest(long valInvest) {
        this.valInvest = valInvest;
    }

    public int getNoDeathBens() {
        return noDeathBens;
    }

    public void setNoDeathBens(int noDeathBens) {
        this.noDeathBens = noDeathBens;
    }

    public long getDb1() {
        return Db1;
    }

    public void setDb1(long db1) {
        Db1 = db1;
    }

    public long getDb2() {
        return Db2;
    }

    public void setDb2(long db2) {
        Db2 = db2;
    }

    public long getDb3() {
        return Db3;
    }

    public void setDb3(long db3) {
        Db3 = db3;
    }

    public long getDb4() {
        return Db4;
    }

    public void setDb4(long db4) {
        Db4 = db4;
    }

    public long getDb5() {
        return Db5;
    }

    public void setDb5(long db5) {
        Db5 = db5;
    }

    public long getDb6() {
        return Db6;
    }

    public void setDb6(long db6) {
        Db6 = db6;
    }

    public long getDb7() {
        return Db7;
    }

    public void setDb7(long db7) {
        Db7 = db7;
    }

    public long getDb8() {
        return Db8;
    }

    public void setDb8(long db8) {
        Db8 = db8;
    }

    public long getDb9() {
        return Db9;
    }

    public void setDb9(long db9) {
        Db9 = db9;
    }

    public long getDb10() {
        return Db10;
    }

    public void setDb10(long db10) {
        Db10 = db10;
        System.out.println("Calling Db10");
    }

    public int getNoMbrShares() {
        return noMbrShares;
    }

    public void setNoMbrShares(int noMbrShares) {
        this.noMbrShares = noMbrShares;
    }

    public long getMs1() {
        return Ms1;
    }

    public void setMs1(long ms1) {
        Ms1 = ms1;
    }

    public long getMs2() {
        return Ms2;
    }

    public void setMs2(long ms2) {
        Ms2 = ms2;
    }

    public long getMs3() {
        return Ms3;
    }

    public void setMs3(long ms3) {
        Ms3 = ms3;
    }

    public long getMs4() {
        return Ms4;
    }

    public void setMs4(long ms4) {
        Ms4 = ms4;
    }

    public long getMs5() {
        return Ms5;
    }

    public void setMs5(long ms5) {
        Ms5 = ms5;
    }

    public long getMs6() {
        return Ms6;
    }

    public void setMs6(long ms6) {
        Ms6 = ms6;
    }

    public long getMs7() {
        return Ms7;
    }

    public void setMs7(long ms7) {
        Ms7 = ms7;
    }

    public long getMs8() {
        return Ms8;
    }

    public void setMs8(long ms8) {
        Ms8 = ms8;
    }

    public long getMs9() {
        return Ms9;
    }

    public void setMs9(long ms9) {
        Ms9 = ms9;
    }

    public long getMs10() {
        return Ms10;
    }

    public void setMs10(long ms10) {
        Ms10 = ms10;
    }

    public static double getComplianceMinimal() {
        return COMPLIANCE_MINIMAL;
    }

    public static double getCompliancePartial() {
        return COMPLIANCE_PARTIAL;
    }

    public static double getComplianceFulll() {
        return COMPLIANCE_FULL;
    }

    public static double getWeightingLight() {
        return WEIGHTING_LIGHT;
    }

    public static double getWeightingMedium() {
        return WEIGHTING_MEDIUM;
    }

    public static double getWeightingHeavy() {
        return WEIGHTING_HEAVY;
    }

    public static double getWeightingMax() {
        return WEIGHTING_MAX;
    }

}
