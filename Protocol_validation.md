## Details of the independent validation steps performed for the protocols

1. Conda environment created using environment.yml (Python 3.9.0)

2. Initialization steps generated some error messages

    **A. No module named jnius_config**

    `ModuleNotFoundError: No module named 'jnius_config'`

    ***This was fixed by*** `pip install pyimagej` and `pip install imagej`

    **B. No module named matplotlib**

    ***This was fixed by*** `pip install matplotlib`

    **C. Error in initializing Fiji**

    `OSError: Sorry, the interactive mode is not available on macOS.`

    ***This was fixed by removing*** `mode='interactive'` from the code

3. Fiji endpoint version 2.9 was initiated

    `ImageJ2/Fiji version: 2.9.0/1.53t`

4. All legacy ImageJ resources, additional Imagej2/Fiji resources, and JAVA-related resources could be loaded

5. 