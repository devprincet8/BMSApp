package com.soarmorrow.bms.repository

import com.soarmorrow.bms.constants.AppConstants
import com.soarmorrow.bms.view.property.details.PropertyImageAdapter
import com.soarmorrow.bms.view.property.details.model.CheckBoxItem
import com.soarmorrow.bms.view.property.details.model.ImagePickerItem
import com.soarmorrow.bms.view.property.listing.model.PropertyItem

class PropertyRepository {
    companion object {
        fun generatePropertyListData(): List<PropertyItem> {
            val listOfCb = mutableListOf<PropertyItem>()
            var imageList = generateImageData()
            var model =
                PropertyItem(
                    "Angel Queen Houseboats", "Shop No 03, Old Bridge, Kumarakom", "15 km distance",
                    imageList
                )
            listOfCb.add(model)
            listOfCb.add(model)
            listOfCb.add(model)
            listOfCb.add(model)
            listOfCb.add(model)
            return listOfCb
        }

        fun generateCheckBoxData(): List<CheckBoxItem> {
            val listOfCb = mutableListOf<CheckBoxItem>()

            var model =
                CheckBoxItem(false, "Family Room")
            listOfCb.add(model)

            model = CheckBoxItem(false, "House Keeping")
            listOfCb.add(model)

            model = CheckBoxItem(false, "Spa")
            listOfCb.add(model)

            model = CheckBoxItem(false, "Honeymoon Suit")
            listOfCb.add(model)

            model = CheckBoxItem(false, "Wifi")
            listOfCb.add(model)

            model = CheckBoxItem(false, "Dry Cleaning")
            listOfCb.add(model)

            model = CheckBoxItem(false, "Restaurant")
            listOfCb.add(model)

            model = CheckBoxItem(false, "Laundry")
            listOfCb.add(model)

            model = CheckBoxItem(false, "Room Service")
            listOfCb.add(model)
            model = CheckBoxItem(false, "Baby Sitting")
            listOfCb.add(model)
            model = CheckBoxItem(false, "Non Smoking Room")
            listOfCb.add(model)
            model = CheckBoxItem(false, "Air Condition")
            listOfCb.add(model)
            model = CheckBoxItem(false, "Massage")
            listOfCb.add(model)
            model = CheckBoxItem(false, "English Speaking")
            listOfCb.add(model)
            model = CheckBoxItem(false, "Pets")
            listOfCb.add(model)
            model = CheckBoxItem(false, "Hindi Speaking")
            listOfCb.add(model)
            model = CheckBoxItem(false, "Water Sports")
            listOfCb.add(model)
            model = CheckBoxItem(false, "Arabic Speaking")
            listOfCb.add(model)
            model = CheckBoxItem(false, "Swimming Pool")
            listOfCb.add(model)

            return listOfCb
        }

        fun generateImageData(): List<ImagePickerItem> {
            val listOfCb = mutableListOf<ImagePickerItem>()

            var model = ImagePickerItem(
                AppConstants.img1,
                PropertyImageAdapter.TYPE_IMAGE
            )
            listOfCb.add(model)

            model = ImagePickerItem(
                AppConstants.img2,
                PropertyImageAdapter.TYPE_IMAGE
            )
            listOfCb.add(model)

            model = ImagePickerItem(
                AppConstants.img3,
                PropertyImageAdapter.TYPE_IMAGE
            )
            listOfCb.add(model)

            model = ImagePickerItem(
                AppConstants.img4,
                PropertyImageAdapter.TYPE_IMAGE
            )
            listOfCb.add(model)

            model = ImagePickerItem(
                AppConstants.img5,
                PropertyImageAdapter.TYPE_IMAGE
            )
            listOfCb.add(model)

            model = ImagePickerItem(
                AppConstants.img6,
                PropertyImageAdapter.TYPE_CAMERA
            )
            listOfCb.add(model)

            return listOfCb
        }

        fun getPropertyType(): List<String> {
            return listOf("Houseboat", "Resort")
        }

        fun getPropertyCommission(): List<String> {
            return listOf(
                "Common Commission 15%",
                "Common Commission 25%",
                "Common Commission 35%"
            )
        }

        fun getPropertyList(): List<String> {
            return listOf(
                "Radwa Travel and Tourism",
                "Angel Houseboats",
                "Hillview Resort",
                "Kerala Lexury Houseboats",
                "Soma Houseboats",
                "Iceberg Resort"
            )
        }
    }


}