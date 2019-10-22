import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { freeApiService} from './services/freeapi_service'

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    freeApiService
  ],
  providers: [freeApiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
