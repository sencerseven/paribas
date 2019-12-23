export class CustomerOutputModel{

   public id:number;
   public tckNumber:string;
   public firstName:string;
   public lastName:string;
   public birthDate:Date;
   public address:string;
   public phoneNumber:string;

    constructor();
    
    constructor(id?:number, 
        tckNumber?:string, 
        firstName?:string, 
        lastName?:string, 
        birthDate?:Date,
        address?:string,
        phoneNumber?:string){

            this.id=id;
            this.tckNumber=tckNumber;
            this.firstName=firstName;
            this.lastName=lastName;
            this.birthDate=birthDate;
            this.address=address;
            this.phoneNumber=phoneNumber;


    }


}