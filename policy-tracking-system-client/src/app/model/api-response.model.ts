export class ApiResponseModel{
    public status:string;
    public code:number;
    public error:string;
    public data:object;

    constructor(status:string,code:number,error:string,data:object){
        this.status=status;
        this.code=code;
        this.error=error;
        this.data=data;
    }
}