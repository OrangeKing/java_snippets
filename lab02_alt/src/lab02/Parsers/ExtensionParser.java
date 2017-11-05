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
public class ExtensionParser implements Parser {

    @Override
    public String parse(String path) {
        return path.substring(path.lastIndexOf('.'));
    }
    
}
