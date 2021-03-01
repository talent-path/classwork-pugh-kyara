import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddBookComponent } from './add-book/add-book.component';
import { BookshelfComponent } from './bookshelf/bookshelf.component';

const routes: Routes = [{path: "", component: BookshelfComponent},
                        {path: "add", component:AddBookComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
