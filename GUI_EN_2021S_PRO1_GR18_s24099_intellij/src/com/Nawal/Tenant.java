package com.Nawal;

public class Tenant {

        String name;
        String cell_phone;
        String pesel;
        String Room;
        Double volofRoom;

        public Tenant(String name, String cell_phone, String pesel, String Room, Double volofRoom) {
            this.name = name;
            this.cell_phone = cell_phone;
            this.Room = Room;
            this.pesel = pesel;
            this.volofRoom=volofRoom;
        }
        public Tenant(Tenant t) {
            this.name = t.name;
            this.cell_phone = t.cell_phone;
            this.pesel = t.pesel;
            this.Room = t.Room;
            this.volofRoom = t.volofRoom;
        }

        public String getName() {
            return name;
        }
        public String getRoom() {
        return Room;
    }
        public String getCell_phone() {
            return cell_phone;
        }
    public void getVolumeofroom(double volofRoom) {
        this.volofRoom = volofRoom;
    }

        public void setName(String name) {
            this.name = name;
        }
        public void setCell_phone(String cell_phone) {
            this.cell_phone = cell_phone;
        }
        public String getpesel() {
        return pesel;
          }
        public void setpesel(String pesel) {
        this.pesel = pesel;
         }
        public void setRoom(String Room) {
        this.Room = Room;
         }
    public void setVolumeofroom(double vvolofRoom) {
        this.volofRoom = volofRoom;
    }


        @Override
        public String toString() {
            return "Tenant [name=" + name + ", cell_phone=" + cell_phone + ", PESEL=" + pesel + ", Room " +Room + ",Volume of room is :" +volofRoom+"]";
        }
}
