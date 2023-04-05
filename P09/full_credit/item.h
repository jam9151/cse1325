#ifndef _ITEM_H
#define _ITEM_H

#include <iostream>
#include <string>

class Item{
    
    public:
        Item(std::string name, int price);
        ~Item();
        std::string to_string();
    
    private:
        std::string _name;
        int _price;
};
#endif