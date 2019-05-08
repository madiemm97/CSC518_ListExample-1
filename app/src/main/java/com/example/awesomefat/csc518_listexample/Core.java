package com.example.awesomefat.csc518_listexample;

import android.widget.ArrayAdapter;

import com.example.awesomefat.csc518_listexample.AirportTree.ATree;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;

//singleton - a class filled with stuff acccccebile by everything
public class Core
{
    public static LinkedListOfCreditCards theCreditCardsLL = new LinkedListOfCreditCards();
    public static LinkedListOfLoyaltyPrograms theLoyaltyProgramsLL = new LinkedListOfLoyaltyPrograms();
    public static CreditCardArrayAdapterForLinkedLists ccCustomAdapter;
    public static LoyaltyProgramArrayAdapterForLinkedLists lpCustomAdapter;
    public static FirebaseDatabase database;
    public static DatabaseReference creditCardRef;
    public static DatabaseReference loyaltyProgramRef;
    public static CreditCard currentSelectedCard = null;
    public static LoyaltyProgram currentSelectedLoyaltyProgram = null;
    public static ItineraryStack currentItinerary = new ItineraryStack();
    public static ATree currTree = null;

    //new stuff
    public static ArrayList<String> businessesArrayList = new ArrayList<String>();
    public static JSONObject obj;
    public static JSONArray businesses;
    //name, url, rating, review count, address, phone
    public static String restaurantName;
    public static String restaurantURL;
    public static String restaurantRating;
    public static int restaurantReviewCount;
    public static String restaurantAddress;
    public static String restaurantPhone;

    public static void addLoyaltyProgramToFirebase(LoyaltyProgram lp)
    {
        Core.loyaltyProgramRef.push().setValue(lp);
    }

    //encapsulated
    public static void addLoyaltyProgramLocally(LoyaltyProgram lp)
    {
        //happens in a static context
        Core.theLoyaltyProgramsLL.addAtEnd(lp);
        Core.lpCustomAdapter.notifyDataSetChanged();
    }

    public static void addCreditCardToFirebase(CreditCard cc)
    {
        Core.creditCardRef.push().setValue(cc);
    }

    public static void addCreditCardLocally(CreditCard cc)
    {
        Core.theCreditCardsLL.addEnd(cc);
        Core.ccCustomAdapter.notifyDataSetChanged();
    }
}
