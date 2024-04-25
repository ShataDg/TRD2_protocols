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

    