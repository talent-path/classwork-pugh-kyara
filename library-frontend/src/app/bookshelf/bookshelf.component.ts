import { Component, OnInit } from '@angular/core';
import {Book} from '../bookclass/Book'
import {LibraryService} from '../library.service'

@Component({
  selector: 'app-bookshelf',
  templateUrl: './bookshelf.component.html',
  styleUrls: ['./bookshelf.component.css']
})
export class BookshelfComponent implements OnInit {

  books: Book[];
  constructor(private libservice: LibraryService) { 
    // this.books = [{bookID:1, title:"TEST", authors:["Me"], year:2021}];
  }

  ngOnInit(): void {
    this.libservice.getAllBooks().subscribe(list => {
      this.books = list
    });
    
  }

}
