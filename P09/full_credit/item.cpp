#include "item.h"

Item:: Item(std::string name, int price)
    :_name{name}, _price{price} {

}

Item:: ~Item(){
    
    //std::cout << "Destructing this object"<<std::endl;

}

std::string Item::to_string(){
    // std::cout << _name << " ($" << _price << ")" << std::endl;
    return "" + _name + " ($" + std::to_string(_price) + ")";
}
