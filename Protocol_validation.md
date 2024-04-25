## Details of the independent validation steps performed for the protocols

1. Conda environment created using environment.yml (Python 3.9.0)

2. Initialization steps generated some error messages

**No module named jnius_config**

`ModuleNotFoundError                       Traceback (most recent call last)
Cell In[1], line 5
      3 import os
      4 import sys
----> 5 import imagej
      6 import scipy.ndimage
      7 import numpy as np

File ~/anaconda3/envs/trd2_protocol/lib/python3.9/site-packages/imagej/__init__.py:1
----> 1 from .imagej import *

File ~/anaconda3/envs/trd2_protocol/lib/python3.9/site-packages/imagej/imagej.py:10
      7 __author__ = 'Yang Liu & Curtis Rueden'
      9 import os
---> 10 import jnius_config
     13 def _debug(message):
     14     """
     15     print debug message
     16 
     17     :param message: Debug message to be printed
     18     :return: None
     19     """

ModuleNotFoundError: No module named 'jnius_config'`

**This was fixed by** `pip install pyimagej` and `pip install imagej`