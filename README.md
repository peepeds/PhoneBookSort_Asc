## Phone Book Program

This program enables users to manage and sort phone book data. Users can input data including First Name, Last Name, Phone Number, Institution, and City, and sort the data based on various parameters in ascending order.

### Restrictions
Using a built-in sorting library is prohibited.

### Usage

1. Run the program.
2. Input phone book data including First Name, Last Name, Phone Number, Institution, and City.
3. Choose a sorting parameter:
   - First Name
   - Last Name
   - Phone Number
   - Institution
   - City
4. The program will display the sorted phone book data.
5. Repeat steps 2-4 as needed.

## Explanation

1. This program is built using the Java language.
2. Class is chosen as the data structure to encapsulate all the data mentioned above, named Contact.
   - Add the final keyword to the attributes to ensure immutability.
   - Build a constructor to assign values to the class variables.
   - Create a display method to output the values of the object.
   - Implement getters to return the object variable values.
3. Implement a sorting function to sort the list of objects.
4. Heap is chosen as the sorting algorithm.
   - HeapSort function is created to build the Heap Tree.
   - Heapify function is responsible for balancing the tree based on the given parameters.
