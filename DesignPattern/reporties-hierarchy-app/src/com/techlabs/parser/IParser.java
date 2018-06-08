package com.techlabs.parser;
import com.techlabs.employee.dto.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.TreeSet;


public interface IParser {

	public TreeSet<Employee> parseFile() throws FileNotFoundException, IOException;
}
