━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

Title: Desi Deli

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

Overview: The Desi Deli is an app that allows you to make and edit sandwiches, add signature sandwiches, and add drinks and chips! Towards the end of your order, you'll be shown your final receipt of what is contained in your order and upon confirming your order a receipt is sent to a receipt is stored as a file and sent to a separate folder.

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

How to Run:

1. Open your IDE (IntelliJ or Visual Studio Code, etc.).

2. Clone/Download the project files.

3. Run the "Main.java" file.

4. Follow the on-screen menu options.

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

Features:

1.) Able to create new orders/exit application.

2.) Add sandwiches to order.

3.) Add drinks to order.

4.) Add chips to order.

5.) Add signature sandwich.

6.) Edit sandwiches made before AND signature sandwiches added.

7.) Checkout -> Shows "cart" and asks for confirmation on checking out.

8.) Cancel Order.

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

Layout Diagram:

<img width="1724" height="957" alt="image" src="https://github.com/user-attachments/assets/e8ec8efc-f05f-433b-854b-7ad611a54aa0" />

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

Helper Menu:


<img width="1040" height="397" alt="image" src="https://github.com/user-attachments/assets/c78d32cd-2cbf-41d4-a321-0d56c7301cd3" />

I created a helper menu that will benefit me throughout a universal amount of projects through gathering the question, the list of options (as strings), and having a boolean to decide if there should be a "Return/Cancel" option based on the menu provided.
This helped me bring my code down from 521 lines to 382 lines. 

<img width="750" height="182" alt="image" src="https://github.com/user-attachments/assets/430c307f-cd88-41fc-ace3-d18a7b1fae52" />

TO

<img width="481" height="503" alt="image" src="https://github.com/user-attachments/assets/fc3c2c27-c5cb-4bb3-a3dc-e22a2025a303" />


━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

FileWriter/BufferedWriter:

<img width="1045" height="284" alt="image" src="https://github.com/user-attachments/assets/bb8d3cc7-f2aa-4d8e-9f93-53218d45a5fe" />

I was able to use FileWriter in a new way! I learned that due to the parameters of the saveReceiptToFileAndFolder containing the Order class, I am able to use the methods within the class, in which case, I was able to use "order.getReceiptFileName()" and "order.getReceiptContent()".

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

Program being run:

<img width="449" height="345" alt="image" src="https://github.com/user-attachments/assets/e947575d-989b-4ba6-a44c-9561e2ce1546" />

<img width="450" height="350" alt="image" src="https://github.com/user-attachments/assets/50892e91-58d3-4218-b4ff-33df2f4038e1" />

<img width="995" height="417" alt="image" src="https://github.com/user-attachments/assets/286b0c55-f322-4e5f-9341-4c34433d49dd" />
