package lab02.Parsers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Norbert
 */
public class DoubleExtensionParser implements Parser {

    @Override
    public String parse(String path) {
        if(path.indexOf('.') != path.lastIndexOf('.'))
            return path.substring(path.indexOf('.'));
        return path.substring(path.lastIndexOf('.'));
    }
    
}
