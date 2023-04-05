#include "item.h"
#include "vending_machine.h"

void VendingMachine::add(std::string name, int price){
    
    items.push_back(Item(name,price));

}
std::string VendingMachine::menu(){
    std::string concatMenu = "";
    int counter = 0;
    for(auto i : items){
        
        concatMenu.append(std::to_string(counter) + ") "+ i.to_string() + "\n");
        counter++;
    }
    return concatMenu;

}

void VendingMachine::buy(int index){
    
    Item choice = items[index];
    std::string test = choice.to_string();

    std::cout << "#### Buying" << items[index].to_string() << std::endl;
}

