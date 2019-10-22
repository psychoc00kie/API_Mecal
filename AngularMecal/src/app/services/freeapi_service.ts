import { Injectable } from "@angular/core"
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class freeApiService
{
   _url: string = " https://jsonplaceholder.typicode.com/posts/1/comments";

   constructor(private httpclient: HttpClient){}
   getcoments(): Observable<any>{
        return this.httpclient.get(" https://jsonplaceholder.typicode.com/posts/1/comments");
   }

}