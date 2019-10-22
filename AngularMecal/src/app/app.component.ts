import { Component } from '@angular/core';
import {freeApiService} from './services/freeapi_service'
import { Comments} from './classes/comments'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AngularMecal';

  list_of_coments : Comments[];

  constructor(private _freeApiService : freeApiService){

  }
    ngOnInit(){
      this._freeApiService.getcoments()
      .subscribe(
        data =>
        {
            this.list_of_coments = data;
        }
      );
    }
    

}
