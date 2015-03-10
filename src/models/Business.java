package models;

import java.util.LinkedList;

import natives.Native;
import natives.NativeGroup;

public interface Business {



//public void sellArmorToNative(Things th, Native nt, Armor arm, int gold);   //sell to a native in exchange for gold
//public void sellWeaponToNative(Things th, Native nt, Weapons arm, int gold);   //sell to a native in exchange for gold
public void sellArmor(Things th, Armor arm);	//sell armor in exchange for gold
public void sellWeapon(Things th, Weapons arms);	//sell weapon in exchange for gold
public void sellTreasure(Things th, TreasureChit tr, int gold);	//sell treasure chit in exchange for gold



//public void buyNative(Things th, NativeGroup nt);		//you can recruit a native with gold
public void buyNative(Things th, LinkedList<NativeGroup> ng, NativeGroup nt);		//you can recruit a native with gold

public void buyArmor(Things th, Armor arm);		//you can buy an armor with gold
public void buyWeapon(Things th, Weapons arms);	//you can buy a weapon with gold
public void buyTreasure(Things th, TreasureChit tr);	//you can buy a weapon with gold





}
