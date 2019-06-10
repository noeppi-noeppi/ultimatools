package de.melanx.ultimatools.items;

import de.melanx.ultimatools.items.crystals.casual.*;
import de.melanx.ultimatools.items.crystals.krypto.*;

public class ModItems {

    // casual
    public static CrystalBeginner crystalBeginner;
    public static CrystalScholar crystalScholar;
    public static CrystalFarmer crystalFarmer;
    public static CrystalForestRunner crystalForestRunner;
    public static CrystalKnight crystalKnight;
    public static CrystalLighter crystalLighter;
    public static CrystalSoothsayer crystalSoothsayer;
    public static CrystalBloodMagician crystalBloodMagician;
    public static CrystalUltimaFighter crystalUltimaFighter;
    public static CrystalCursedKnight crystalCursedKnight;
    public static CrystalUltimaGod crystalUltimaGod;
    public static CrystalOreBetter crystalOreBetter;

    // krypto
    public static KryptoBeginner kryptoBeginner;
    public static KryptoScholar kryptoScholar;
    public static KryptoFarmer kryptoFarmer;
//    public static KryptoForestRunner kryptoForestRunner;
//    public static KryptoKnight kryptoKnight;
//    public static KryptoLighter kryptoLighter;
    public static KryptoSoothsayer kryptoSoothsayer;
    public static KryptoBloodMagician kryptoBloodMagician;
    public static KryptoCursedKnight kryptoCursedKnight;

    public static void init() {

        // casual
        crystalBeginner = new CrystalBeginner();
        crystalScholar = new CrystalScholar();
        crystalFarmer = new CrystalFarmer();
        crystalForestRunner = new CrystalForestRunner();
        crystalKnight = new CrystalKnight();
        crystalLighter = new CrystalLighter();
        crystalSoothsayer = new CrystalSoothsayer();
        crystalBloodMagician = new CrystalBloodMagician();
        crystalUltimaFighter = new CrystalUltimaFighter();
        crystalCursedKnight = new CrystalCursedKnight();
        crystalUltimaGod = new CrystalUltimaGod();
        crystalOreBetter = new CrystalOreBetter();

        // krypto
        kryptoBeginner = new KryptoBeginner();
        kryptoScholar = new KryptoScholar();
        kryptoFarmer = new KryptoFarmer();
//        kryptoForestRunner = new KryptoForestRunner();


        kryptoSoothsayer = new KryptoSoothsayer();
        kryptoBloodMagician = new KryptoBloodMagician();
        kryptoCursedKnight = new KryptoCursedKnight();
    }

}
