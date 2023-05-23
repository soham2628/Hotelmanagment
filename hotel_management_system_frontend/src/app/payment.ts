import { provideCloudflareLoader } from "@angular/common";

export class Payment {
payementId:number;
hotelId:number;
userName:String;
name:String;
district:String;
state:String;
zipCode:String;
contactNumber:number;
price:number;
checkIn:Date;
checkOut:Date;
nameOnCard:String;
cardNumber:String;
cvv:number;
expiryYear:String;
hotelName:String;
paidDate:String
constructor(payementId:number,hotelId:number,userName:String,name:String,district:String,state:String,zipCode:String,contactNumber:number,price:number,
    checkIn:Date,checkOut:Date,nameOnCard:String,cardNumber:String,cvv:number,expiryYear:String,hotelName:String,paidDate:String){
        this.payementId=payementId;
        this.hotelId=hotelId;
        this.userName=userName;
        this.name=name;
        this.district=district;
        this.state=state;
        this.zipCode=zipCode;
        this.contactNumber=contactNumber;
        this.price=price;
        this.checkIn=checkIn;
        this.checkOut=checkOut;
        this.nameOnCard=nameOnCard;
        this.cardNumber=cardNumber;
        this.cvv=cvv;
        this.expiryYear=expiryYear;
        this.hotelName=hotelName;
        this.paidDate=paidDate;
}
}