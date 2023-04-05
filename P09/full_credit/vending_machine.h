#ifndef _VENDING_MACHINE_H
#define _VENDING_MACHINE_H
#include "item.h"
#include <iostream>
#include <vector>

class VendingMachine{
    
    public:

        void add(std::string name, int price);
        std::string menu();
        void buy(int index);

    private:
        std::vector<Item> items;
};


#endif