#include <iostream>
#include "item.h"
#include "vending_machine.h"

int main(){
    int choice;

    VendingMachine vm;
    
    vm.add("The Most Amazing Pack of Gum You Will Ever Chew {:", 100000);
    vm.add("The Worst Pack of Gum You Will Ever Chew ):", 1);
    
    
    std::cout << "======================" << std::endl 
    << "Welcome to UTA Vending" 
    << std::endl << "======================" << std::endl 
    << "Please make a choice from the menu." << std::endl << std::endl;

    std::cout << vm.menu();
    std::cin >> choice;
    vm.buy(choice);

    return 0;
}

