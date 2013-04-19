package com.company.project

//import grails.converters.JSON
import grails.converters.XML

import grails.plugin.gson.converters.GSON

class BookController {

    def list() { 
        withFormat {
            xml {
                render Book.list() as XML
            }
            json {
                render Book.list() as GSON
            }
        }
    }

    def show(Integer id) {
        def book = Book.get(id)
        if(book) {
            withFormat {
                xml {
                    render book as XML
                }
                json {
                    render book as GSON
                }
            }
        } else {
            render 'Book not found'
        }
    }
}
