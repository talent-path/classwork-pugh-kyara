import { Component, OnInit } from '@angular/core';
import { BookComponent } from '../book/book.component'
import { LibraryService } from '../library.service';
import {Book} from '../bookclass/Book'
import {Router} from '@angular/router'

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  title: string
  year: number;

  constructor(private service : LibraryService, private router: Router) { }

  ngOnInit(): void {
  }

  addBook()
  {
    let authors : string[] = ["Some Author"];
    let toAdd : Book = { title: this.title, authors: authors, year: this.year}
    //naviagtes to main list of books after adding a new book
    this.service.addBook(toAdd).subscribe((_)=> {this.router.navigate([""])});
  }

}
