/**
 * Name: Jeremy Hagerman
 * Date: 4/1/2022
 * Week 12 Assignment: Serialization
 * 
 */

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

    static ArrayList<Serial> arrayList = new ArrayList<>();

    // 5 Name Entries; containing ID, name, phone number, 
    public static void main(String[] args) {
        Serial p1 = new Serial("101", "Abigail", "987654321", "01/30/1996", "example@gmail.com");
        Serial p2 = new Serial("102", "Franklin", "8765430987", "11/21/1999", "test@gmail.com");
        Serial p3 = new Serial("103", "Will", "9999999999", "04/01/2006", "abc@aol.com");
        Serial p4 = new Serial("104", "Passos", "014671032", "06/29/1999", "BNB@gmail.com");
        Serial p5 = new Serial("105", "Benjamin", "9881655441", "07/14/1995", "Pro@yahoo.com");

        arrayList.add(p1);
        arrayList.add(p2);
        arrayList.add(p3);
        arrayList.add(p4);
        arrayList.add(p5);

        // Driver and Scanner objects
        Driver osd = new Driver();
        Scanner sc = new Scanner(System.in);

        // Menu listing option; 0 set to default. Program somehow accidentally did it's own thing without this parameter set.
        while (menu()) {
            int choice = 0;
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
            
            // Option 1; Add information into a file, do 2 first before selecting 1 otherwise nothing will be added.
                case 1:
                    osd.addInformationIntoAFile(arrayList);
                    break;

                    
            // Option 2: Retrieve information from a file and display them
                case 2: {
                    try {
                        osd.retreiveInformationFromAFile();
                    } 
                    
                    catch (IOException ex) {
                    }
                }
                break;

             // Option 3: Delete information upon inputting an ID number
                case 3:
                    System.out.print("Enter a user's ID Number for deletion: ");
                    String pIDNumber = sc.nextLine();

                    Serial SerialDel = null;
                    for (Serial st : arrayList) {
                        if (st.getId().equalsIgnoreCase(pIDNumber)) {
                            SerialDel = st;
                        }
                    }
                    //If the user appears as null, show an error message.
                    if (SerialDel == null) {
                        System.out.println("Invalid User ID. Try again.");
                    // Remove from list upon successful ID number
                    } else {
                        arrayList.remove(SerialDel);
                    }
                    break;
                    
                    
                // Option 4: Update information
                case 4:
                    osd.addInformationIntoAFile(arrayList);
                    break;

                    
                // Option 5: End loop and the program
                case 5:
                    System.out.println("Shutting down...");
                    //exit program
                    System.exit(0);
                    break;

                // If numbers 1-5 are not selected. Loop back.
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
        sc.close();

    }

    /**
     *
     * @return
     */
    public static boolean menu() {
        System.out.println("1: Add information into a file."
                + "\n2: Retrieve information from a file and display them."
                + "\n3: Delete information."
                + "\n4: Update information."
                + "\n5: Exit."
                + "\n");
        System.out.print("Please select an option: ");
        return true;
    }


    private void addInformationIntoAFile(ArrayList<Serial> arrayList) {
        try {
            FileOutputStream fos = new FileOutputStream(new File("person.bin")); // person.bin selected as area for files to go to and from
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            
            oos.writeObject(arrayList);      
            oos.close();
            
        } catch (IOException ex) {
            System.out.println("" + ex.getMessage());
        }
    }

    /**
     *
     * @throws IOException
     */
    private void retreiveInformationFromAFile() throws IOException {
        ObjectInputStream os = null;

        ArrayList<Serial> retreivedData = null;
        try {

            FileInputStream is = new FileInputStream("person.bin");

            os = new ObjectInputStream(is);

            retreivedData = (ArrayList<Serial>) os.readObject();

            // Do something with the object
        } catch (EOFException e) {
            System.out.println("" + e.getMessage());
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("" + ex.getMessage());

        } finally {
            try {
                os.close();
            } catch (IOException iOException) {
                System.out.println("" + iOException.getMessage());
            }
        }

        for (Serial serial : retreivedData) {
            System.out.println(serial.toString());
        }
    }

}