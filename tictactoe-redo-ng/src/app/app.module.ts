import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TttBoardComponent } from './ttt-board/ttt-board.component';
import { TttSquareComponent } from './ttt-square/ttt-square.component';

@NgModule({
  declarations: [
    AppComponent,
    TttBoardComponent,
    TttSquareComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
